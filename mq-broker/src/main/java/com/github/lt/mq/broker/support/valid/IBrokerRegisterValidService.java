package com.github.lt.mq.broker.support.valid;

import com.github.lt.mq.broker.dto.BrokerRegisterReq;

/**
 * 注册验证方法
 */
public interface IBrokerRegisterValidService {

    /**
     * 生产者验证合法性
     * @param registerReq 注册信息
     * @return 结果
     */
    boolean producerValid(BrokerRegisterReq registerReq);

    /**
     * 消费者验证合法性
     * @param registerReq 注册信息
     * @return 结果
     */
    boolean consumerValid(BrokerRegisterReq registerReq);

}
