package com.github.lt.mq.consumer.api;

import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.common.resp.ConsumerStatus;


public interface IMqConsumerListener {


    /**
     * 消费
     * @param mqMessage 消息体
     * @param context 上下文
     * @return 结果
     */
    ConsumerStatus consumer(final MqMessage mqMessage,
                            final IMqConsumerListenerContext context);

}
