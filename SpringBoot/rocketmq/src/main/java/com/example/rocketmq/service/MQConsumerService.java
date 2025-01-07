package com.example.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.example.rocketmq.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.constant.LoggerName;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.channels.ClosedSelectorException;

@Slf4j
@Component
public class MQConsumerService {

    @Service
    @RocketMQMessageListener(
            topic = "TestTopic",
            selectorExpression = "tag1",
            consumerGroup = "TestGroup"
    )
    public class ConsumerSend implements RocketMQListener<User> {
        // 收到消息就执行这个方法
        public void onMessage(User user) {
            log.info("监听到消息：user={}", JSON.toJSONString(user));
        }
    }

/*    @Service
    @RocketMQMessageListener(
            topic = "TestTopic",
            consumerGroup = "TestGroup"
    )
    public class ConsumerSend2 implements RocketMQListener<String>{

        @Override
        public void onMessage(String s) {
            log.info("监听到消息：str={}",s);
        }
    }*/

    @Service
    @RocketMQMessageListener(
            topic = "TestTopic",
            selectorExpression = "tag2",
            consumerGroup = "TestGroup"
    )
    public class Consumer implements RocketMQListener<MessageExt> {
        public void onMessage(MessageExt messageExt) {
            byte[] body = messageExt.getBody();
            String msg = new String(body);
            log.info("监听到消息：msg={}", msg);
        }
    }

}
