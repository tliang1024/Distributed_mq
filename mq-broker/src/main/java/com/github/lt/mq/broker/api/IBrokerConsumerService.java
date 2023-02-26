/*
 * Copyright (c)  2019. houbinbin Inc.
 * rpc All rights reserved.
 */

package com.github.lt.mq.broker.api;


import com.github.houbb.load.balance.api.ILoadBalance;
import com.github.lt.mq.broker.dto.ChannelGroupNameDto;
import com.github.lt.mq.broker.dto.ServiceEntry;
import com.github.lt.mq.broker.dto.consumer.ConsumerSubscribeBo;
import com.github.lt.mq.broker.dto.consumer.ConsumerSubscribeReq;
import com.github.lt.mq.broker.dto.consumer.ConsumerUnSubscribeReq;
import com.github.lt.mq.common.dto.req.MqHeartBeatReq;
import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.common.dto.resp.MqCommonResp;
import io.netty.channel.Channel;

import java.util.List;

/**
 * 消费者注册服务类
 */
public interface IBrokerConsumerService {

    /**
     * 设置负载均衡策略
     * @param loadBalance 负载均衡
     */
     void loadBalance(ILoadBalance<ConsumerSubscribeBo> loadBalance);

    /**
     * 注册当前服务信息
     * （1）将该服务通过 {@link ServiceEntry#getGroupName()} 进行分组
     * 订阅了这个 serviceId 的所有客户端
     * @param serviceEntry 注册当前服务信息
     * @param channel channel
     */
    MqCommonResp register(final ServiceEntry serviceEntry, Channel channel);

    /**
     * 注销当前服务信息
     * @param serviceEntry 注册当前服务信息
     * @param channel channel
     */
    MqCommonResp unRegister(final ServiceEntry serviceEntry, Channel channel);

    /**
     * 监听服务信息
     * （1）监听之后，如果有任何相关的机器信息发生变化，则进行推送。
     * （2）内置的信息，需要传送 ip 信息到注册中心。
     *
     * @param serviceEntry 客户端明细信息
     * @param clientChannel 客户端 channel 信息
     */
    MqCommonResp subscribe(final ConsumerSubscribeReq serviceEntry,
                   final Channel clientChannel);

    /**
     * 取消监听服务信息
     * （1）监听之后，如果有任何相关的机器信息发生变化，则进行推送。
     * （2）内置的信息，需要传送 ip 信息到注册中心。
     *
     * @param serviceEntry 客户端明细信息
     * @param clientChannel 客户端 channel 信息
     */
    MqCommonResp unSubscribe(final ConsumerUnSubscribeReq serviceEntry,
                   final Channel clientChannel);

    /**
     * 获取所有匹配的消费者-主动推送
     * 1. 同一个 groupName 只返回一个，注意负载均衡
     * 2. 返回匹配当前消息的消费者通道
     *
     * @param mqMessage 消息体
     * @return 结果
     */
    List<ChannelGroupNameDto> getPushSubscribeList(MqMessage mqMessage);

    /**
     * 心跳
     * @param mqHeartBeatReq 入参
     * @param channel 渠道
     */
    void heartbeat(final MqHeartBeatReq mqHeartBeatReq, Channel channel);

    /**
     * 校验有效性
     * @param channelId 通道唯一标识
     */
    void checkValid(final String channelId);

}
