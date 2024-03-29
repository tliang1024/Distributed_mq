package com.github.lt.mq.consumer.support.broker;

import com.github.lt.mq.common.api.Destroyable;
import com.github.lt.mq.common.dto.req.MqCommonReq;
import com.github.lt.mq.common.dto.req.component.MqConsumerUpdateStatusDto;
import com.github.lt.mq.common.dto.resp.MqCommonResp;
import com.github.lt.mq.common.dto.resp.MqConsumerPullResp;
import com.github.lt.mq.common.resp.ConsumerStatus;
import io.netty.channel.Channel;

import java.util.List;


public interface IConsumerBrokerService extends Destroyable {

    /**
     * 初始化列表
     * @param config 配置
     */
    void initChannelFutureList(final ConsumerBrokerConfig config);

    /**
     * 注册到服务端
     */
    void registerToBroker();

    /**
     * 调用服务端
     * @param channel 调用通道
     * @param commonReq 通用请求
     * @param respClass 类
     * @param <T> 泛型
     * @param <R> 结果
     * @return 结果
     */
    <T extends MqCommonReq, R extends MqCommonResp> R callServer(Channel channel,
                                                                 T commonReq,
                                                                 Class<R> respClass);

    /**
     * 获取请求通道
     * @param key 标识
     * @return 结果
     */
    Channel getChannel(String key);

    /**
     * 订阅
     * @param topicName topic 名称
     * @param tagRegex 标签正则
     * @param consumerType 消费者类型
     */
    void subscribe(String topicName, String tagRegex, String consumerType);

    /**
     * 取消订阅
     * @param topicName topic 名称
     * @param tagRegex 标签正则
     * @param consumerType 消费者类型
     */
    void unSubscribe(String topicName, String tagRegex, String consumerType);

    /**
     * 心跳
     */
    void heartbeat();

    /**
     * 拉取消息
     * @param topicName 标题名称
     * @param tagRegex 标签正则
     * @param fetchSize 大小
     * @return 结果
     */
    MqConsumerPullResp pull(String topicName,
                            String tagRegex,
                            int fetchSize);

    /**
     * 消费状态回执
     * @param messageId 消息唯一标识
     * @param consumerStatus 消费状态
     * @return 结果
     */
    MqCommonResp consumerStatusAck(String messageId,
                             ConsumerStatus consumerStatus);

    /**
     * 消费状态回执-批量
     * @param statusDtoList 状态列表
     * @return 结果
     */
    MqCommonResp consumerStatusAckBatch(List<MqConsumerUpdateStatusDto> statusDtoList);

}
