package com.sershare.asset.data.standard.wsmq.wsmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragelyByCircle;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class WsMqConsumer implements DisposableBean {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${wsmq.consumer.address}")
    private String server;

    private String subExpression = "All";
    private Map<String, DefaultMQPushConsumer> consumers = new HashMap<>();

    @Override
    public void destroy() {
        consumers.forEach((k, v) -> v.shutdown());
        logger.info("close mq consumer");
    }

    public boolean registerMessageListener(String topic, String consumerGroup,
                                        MessageListenerConcurrently messageListenerConcurrently) throws MQClientException {

        boolean bSuccess = false;
        synchronized (this) {
            do {
                DefaultMQPushConsumer consumer = consumers.get(topic);
                if (consumer == null) {
                    String groupName = consumerGroup + topic;
                    consumer = new DefaultMQPushConsumer(groupName);
                    consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragelyByCircle());
                    consumer.setNamesrvAddr(server);
                    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
                    consumer.subscribe(topic, subExpression);
                    consumers.put(topic, consumer);
                    logger.info("topic:{}, consumerGroup:{}, groupName:{}", topic, consumerGroup, groupName);
                }
                consumer.registerMessageListener(messageListenerConcurrently);
                bSuccess = true;
            }while (false);
        }
        return bSuccess;
    }

    public boolean registerMessageListener(String topic, String tag, String consumerGroup,
            MessageListenerConcurrently messageListenerConcurrently) throws MQClientException {

		boolean bSuccess = false;
		synchronized (this) {
		do {
		DefaultMQPushConsumer consumer = consumers.get(topic);
		if (consumer == null) {
			String groupName = consumerGroup + topic;
			consumer = new DefaultMQPushConsumer(groupName);
			consumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragelyByCircle());
			consumer.setNamesrvAddr(server);
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
			consumer.subscribe(topic, tag);
			consumers.put(topic, consumer);
		}
		consumer.registerMessageListener(messageListenerConcurrently);
		bSuccess = true;
		}while (false);
		}
		return bSuccess;
    }
    
    public void start() {
        consumers.forEach((k, v) -> {
            try {
                v.start();
            } catch (MQClientException e) {
                logger.error(e.getErrorMessage());
            }
        });
        logger.info("start mq consumer.");
    }

    
}
