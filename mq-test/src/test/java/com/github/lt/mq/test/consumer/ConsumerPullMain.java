package com.github.lt.mq.test.consumer;

import com.alibaba.fastjson.JSON;
import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.common.resp.ConsumerStatus;
import com.github.lt.mq.consumer.api.IMqConsumerListener;
import com.github.lt.mq.consumer.api.IMqConsumerListenerContext;
import com.github.lt.mq.consumer.core.MqConsumerPull;


public class ConsumerPullMain {

    //1. 首先启动消费者，然后启动生产者。
    public static void main(String[] args) {
        final MqConsumerPull mqConsumerPull = new MqConsumerPull();
        mqConsumerPull.appKey("test")
                .appSecret("mq");
        mqConsumerPull.start();

        mqConsumerPull.subscribe("TOPIC", "TAGA");
        mqConsumerPull.registerListener(new IMqConsumerListener() {
            @Override
            public ConsumerStatus consumer(MqMessage mqMessage, IMqConsumerListenerContext context) {
                System.out.println("---------- 自定义 " + JSON.toJSONString(mqMessage));
                return ConsumerStatus.SUCCESS;
            }
        });
    }

}
