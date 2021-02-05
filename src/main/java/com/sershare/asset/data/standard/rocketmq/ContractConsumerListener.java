package com.sershare.asset.data.standard.rocketmq;

import com.google.gson.JsonObject;
import com.sershare.asset.data.standard.rocketmq.model.MqMessage;
import com.sershare.asset.data.standard.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Queue;

/**
 * @author clear
 * @desc 贷款合同消费者监听器
 * @date 2021/1/11 2:48 下午
 */
@Slf4j
@Component
@RocketMQMessageListener(
        consumerGroup = "${rocketmq.consumer.group}",
        topic = "${rocketmq.consumer.topic.newfile01topic}"
)
public class ContractConsumerListener implements RocketMQListener<MessageExt>{

    @Resource(name = "msgTempQueue")
    private Queue<JsonObject> msgTempQueue;

    @Override
    public void onMessage(MessageExt message) {
        String body = new String(message.getBody());
        MqMessage mqMessage = GsonUtils.fromString(body, MqMessage.class);
        log.info("consumer topic:{} message: {}", message.getTopic(), mqMessage.getUnZipBody());
        JsonObject jsonObject = GsonUtils.stringToJson(mqMessage.getUnZipBody());
        msgTempQueue.offer(jsonObject);
    }

}
