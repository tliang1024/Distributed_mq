package com.github.lt.mq.consumer.support.listener;

import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.common.resp.ConsumerStatus;
import com.github.lt.mq.consumer.api.IMqConsumerListener;
import com.github.lt.mq.consumer.api.IMqConsumerListenerContext;

public interface IMqListenerService {

    /**
     * 注册
     * @param listener 监听器
     */
    void register(final IMqConsumerListener listener);

    /**
     * 消费消息
     * @param mqMessage 消息
     * @param context 上下文
     * @return 结果
     */
    ConsumerStatus consumer(final MqMessage mqMessage,
                            final IMqConsumerListenerContext context);

}
