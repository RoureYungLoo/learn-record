package com.example.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.example.rocketmq.entity.User;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class MQProducerService {

    @Value("${rocketmq.producer.send-message-timeout}")
    private Integer messageTimeout;

    private static final String topic = "TestTopic";

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /* 普通发送 */
    public void send(User user) {
        rocketMQTemplate.convertAndSend(topic + ":tag1", user);
        // rocketMQTemplate.convertAndSend(topic+"tag1", MessageBuilder.withPayload(user).build());
    }

    /* 同步发送 */
    public SendResult sendMsg(String msg) {
        SendResult sendResult = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(msg).build());
        log.info("sendResult={}", JSON.toJSONString(sendResult));
        return sendResult;
    }

    /* 异步发送 */
    public void sendAsyncMsg(String msg) {
        rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(msg).build(), new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("async send result={}", sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("async send exception={}", throwable.getMessage());

            }
        });
    }

    /* 延时发送 */
    public void sendDelayMsg(String msg, int delayLevel) {
        rocketMQTemplate.syncSend(
                topic,
                MessageBuilder.withPayload(msg).build(),
                messageTimeout,
                delayLevel
        );
    }

    /* 发送单向消息 */
    public void sendOneWayMsg(String msg) {
        rocketMQTemplate.sendOneWay(
                topic,
                MessageBuilder.withPayload(msg).build()
        );
    }

    /* 发送带tag的消息 */
    public SendResult sendTagMsg(String msg) {
        return rocketMQTemplate.syncSend(topic + ":tag2", MessageBuilder.withPayload(msg).build());
    }
}
