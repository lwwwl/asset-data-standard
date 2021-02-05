package com.sershare.asset.data.standard.wsmq.wsmq;

import com.google.gson.Gson;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


@Component
public class WsMqProducer implements DisposableBean, InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wsmq.producer.address}")
    private String server;
    @Value("${wsmq.producer.group}")
    private String producerGroup;
    @Value("${wsmq.producer.system}")
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
            	logger.info("发送mq消息，响应结果| {}", sendResult);
            	bSuccess = true;
            } catch (MQClientException e) {
                logger.error(e.getErrorMessage());
            } catch (RemotingException e) {
                logger.error(e.getMessage());
            } catch (MQBrokerException e) {
                logger.error(e.getErrorMessage());
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
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
        mqHeader.setTimestamp(new Date());
        return mqHeader;
    }

    public Message createMqMessage(String topic, String body) {
        Message message = new Message();
        message.setTags(subExpression);
        message.setTopic(topic);

        MqMessage mqMessage = new MqMessage();
        mqMessage.setMqHeader(this.createMqHeader());
        mqMessage.setUnZipBody(body);

        Gson gson = new Gson();
        message.setBody(gson.toJson(mqMessage).getBytes());
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
        mqNewHeader.setTimestamp(new Date());
        mqNewHeader.setSystem(system);

        MqMessage mqMessage = new MqMessage();
        mqMessage.setMqHeader(mqNewHeader);
        mqMessage.setUnZipBody(body);

        Gson gson = new Gson();
        message.setBody(gson.toJson(mqMessage).getBytes());
        return message;
    }

    public Message createMqMessage(String topic, MessageExt messageExt, String body) {
        Gson gson = new Gson();
        MqMessage mqMessage = gson.fromJson(messageExt.getBody().toString(), MqMessage.class);

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
        message.setBody(gson.toJson(mqNewMessage).getBytes());
        return message;
    }
    
    
    public boolean sendMsg(String topic, String tags, String body) {
    	Message message = new Message();
        message.setTags(tags);
        message.setTopic(topic);
        message.setBody(body.getBytes());
    	return send(message);
    }
}
