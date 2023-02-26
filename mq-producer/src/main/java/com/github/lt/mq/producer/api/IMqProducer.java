package com.github.lt.mq.producer.api;

import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.producer.dto.SendBatchResult;
import com.github.lt.mq.producer.dto.SendResult;

import java.util.List;


public interface IMqProducer {

    /**
     * 同步发送消息
     * @param mqMessage 消息类型
     * @return 结果
     */
    SendResult send(final MqMessage mqMessage);

    /**
     * 单向发送消息
     * @param mqMessage 消息类型
     * @return 结果
     */
    SendResult sendOneWay(final MqMessage mqMessage);

    /**
     * 同步发送消息-批量
     * @param mqMessageList 消息类型
     * @return 结果
     */
    SendBatchResult sendBatch(final List<MqMessage> mqMessageList);

    /**
     * 单向发送消息-批量
     * @param mqMessageList 消息类型
     * @return 结果
     */
    SendBatchResult sendOneWayBatch(final List<MqMessage> mqMessageList);

}
