package com.example.rocketmq.controller;

import com.example.rocketmq.entity.User;
import com.example.rocketmq.service.MQProducerService;
import com.example.rocketmq.util.Result;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rocketmq")
public class RocketMQController {


    @Autowired
    private MQProducerService mqProducerService;

    @GetMapping("/send")
    public void send() {
        User user = new User();
        user.setAge(12);
        user.setName("测试用户");
        mqProducerService.send(user);
    }

    @GetMapping("/sendtag")
    public SendResult sendTag() {
        SendResult sendResult = mqProducerService.sendTagMsg("带有tag的消息");
        // return  Result.success(sendResult);
        return  sendResult;

    }
}
