package com.github.lt.mq.common.dto.resp;

/**
 * 消息消费结果
 */
public class MqConsumerResultResp extends MqCommonResp {

    /**
     * 消费状态
     */
    private String consumerStatus;

    public String getConsumerStatus() {
        return consumerStatus;
    }

    public void setConsumerStatus(String consumerStatus) {
        this.consumerStatus = consumerStatus;
    }
}
