package com.github.lt.mq.test.producer;

import com.alibaba.fastjson.JSON;
import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.producer.core.MqProducer;
import com.github.lt.mq.producer.dto.SendResult;

import java.util.Arrays;


public class ProducerMain {

    public static void main(String[] args) {
        MqProducer mqProducer = new MqProducer();
        mqProducer.appKey("test")
                .appSecret("mq");
        mqProducer.start();

        for(int i = 0; i < 20; i++) {
            MqMessage mqMessage = buildMessage(i);
            SendResult sendResult = mqProducer.send(mqMessage);
            System.out.println(JSON.toJSON(sendResult));
        }
    }

    private static MqMessage buildMessage(int i) {
        String message = "HELLO MQ!" + i;
        MqMessage mqMessage = new MqMessage();
        mqMessage.setTopic("TOPIC");
        mqMessage.setTags(Arrays.asList("TAGA", "TAGB"));
        mqMessage.setPayload(message);

        return mqMessage;
    }

}
