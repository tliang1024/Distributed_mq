package com.github.lt.mq.broker.support.persist;

import com.github.lt.mq.broker.dto.persist.MqMessagePersistPut;
import com.github.lt.mq.common.dto.req.MqConsumerPullReq;
import com.github.lt.mq.common.dto.req.component.MqConsumerUpdateStatusDto;
import com.github.lt.mq.common.dto.resp.MqCommonResp;
import com.github.lt.mq.common.dto.resp.MqConsumerPullResp;
import io.netty.channel.Channel;

import java.util.List;

public interface IMqBrokerPersist {

    /**
     * 保存消息
     * @param mqMessage 消息
     * @return 响应
     */
    MqCommonResp put(final MqMessagePersistPut mqMessage);

    /**
     * 保存消息-批量
     * @param putList 消息
     * @return 响应
     */
    MqCommonResp putBatch(final List<MqMessagePersistPut> putList);

    /**
     * 更新状态
     * @param messageId 消息唯一标识
     * @param consumerGroupName 消费者分组名称
     * @param status 状态
     * @return 结果
     */
    MqCommonResp updateStatus(final String messageId,
                              final String consumerGroupName,
                              final String status);

    /**
     * 更新状态-批量
     * @param statusDtoList 状态列表
     * @return 结果
     */
    MqCommonResp updateStatusBatch(List<MqConsumerUpdateStatusDto> statusDtoList);

    /**
     * 拉取消息
     * @param pull 拉取消息
     * @param channel 通道
     * @return 结果
     */
    MqConsumerPullResp pull(final MqConsumerPullReq pull, final Channel channel);

}
