package com.sershare.asset.data.standard.rocketmq;

import com.sershare.asset.data.standard.rocketmq.model.MqHeader;
import com.sershare.asset.data.standard.rocketmq.model.MqMessage;
import com.sershare.asset.data.standard.utils.DateUtils;
import com.sershare.asset.data.standard.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

import static com.sershare.asset.data.standard.utils.DateUtils.DATEPATTERN_YYYYMMDDHHMMSS;

/**
 * @author clear
 * @desc
 * @date 2021/1/11 11:07 上午
 */
@Component
@Slf4j
@ConditionalOnProperty(name = "rocketmq.producer.enable", havingValue = "true")
public class RocketMqSendService implements InitializingBean, DisposableBean {

    @Value("${rocketmq.nameServer}")
    private String server;
    @Value("${rocketmq.producer.group}")
    private String producerGroup;
    @Value("${rocketmq.producer.system}")
    private String system;

    private String subExpression = "All";

    private DefaultMQProducer producer;

    @Override
    public void afterPropertiesSet() throws MQClientException {
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(server);
        producer.start();
    }

    @Override
    public void destroy(){
        producer.shutdown();
    }

    public boolean send(Message message){
        boolean bSuccess = false;
        do {
            try {
                SendResult sendResult = producer.send(message);
                bSuccess = true;
                log.info("发送mq消息，响应结果| {}", sendResult);
            } catch (MQClientException e) {
                log.error(e.getErrorMessage());
            } catch (RemotingException e) {
                log.error(e.getMessage());
            } catch (MQBrokerException e) {
                log.error(e.getErrorMessage());
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        } while (false);
        return bSuccess;
    }

    private MqHeader createMqHeader(){
        MqHeader mqHeader = new MqHeader();
        String uuid = UUID.randomUUID().toString();
        mqHeader.setRoot(uuid);
        mqHeader.setCurrent(uuid);
        mqHeader.setPre(null);
        mqHeader.setSystem(system);
        mqHeader.setTimestamp(DateUtils.getCurrentTime(DATEPATTERN_YYYYMMDDHHMMSS));
        return mqHeader;
    }

    public Message createMqMessage(String topic, String body) {
        Message message = new Message();
        message.setTags(subExpression);
        message.setTopic(topic);

        MqMessage mqMessage = new MqMessage();
        mqMessage.setMqHeader(this.createMqHeader());
        mqMessage.setUnZipBody(body);

        message.setBody(GsonUtils.toString(mqMessage).getBytes());
        return message;
    }

    public Message createMqMessage(String topic, MqHeader mqOldHeader, String body) {
        Message message = new Message();
        message.setTags(subExpression);
        message.setTopic(topic);

        MqHeader mqNewHeader = new MqHeader();
        mqNewHeader.setCurrent(UUID.randomUUID().toString());
        mqNewHeader.setPre(mqOldHeader.getCurrent());
        mqNewHeader.setRoot(mqOldHeader.getRoot());
        mqNewHeader.setTimestamp(DateUtils.getCurrentTime(DATEPATTERN_YYYYMMDDHHMMSS));
        mqNewHeader.setSystem(system);

        MqMessage mqMessage = new MqMessage();
        mqMessage.setMqHeader(mqNewHeader);
        mqMessage.setUnZipBody(body);

        message.setBody(GsonUtils.toString(mqMessage).getBytes());
        return message;
    }

    public Message createMqMessage(String topic, MessageExt messageExt, String body) {
        MqMessage mqMessage = GsonUtils.fromString(messageExt.getBody().toString(), MqMessage.class);

        MqHeader mqHeader = this.createMqHeader();
        mqHeader.setRoot(mqMessage.getMqHeader().getRoot());
        mqHeader.setPre(mqMessage.getMqHeader().getCurrent());
        mqHeader.setCurrent(UUID.randomUUID().toString());

        MqMessage mqNewMessage = new MqMessage();
        mqNewMessage.setMqHeader(mqHeader);
        mqNewMessage.setUnZipBody(body);
        mqNewMessage.setMqHeader(mqHeader);
        mqNewMessage.setUnZipBody(body);

        Message message = new Message();
        message.setTags(subExpression);
        message.setTopic(topic);
        message.setBody(GsonUtils.toString(mqMessage).getBytes());
        return message;
    }


    /**
     * 发送消息
     * @param topic 消息主题
     * @param tags 消息标签
     * @param body 消息体
     * @return 是否发送成功
     */
    public boolean sendMsg(String topic, String tags, String body) {
        Message message = new Message();
        message.setTags(tags);
        message.setTopic(topic);
        message.setBody(body.getBytes());
        return send(message);
    }

    /**
     * 发送消息
     * @param topic 消息主题
     * @param body 消息体
     * @return 是否发送成功
     */
    public boolean sendMsg(String topic, String body) {
        Message message = new Message();
        message.setTopic(topic);
        message.setBody(body.getBytes());
        return send(message);
    }

}
