package com.github.lt.mq.common.dto.resp;

import com.github.lt.mq.common.dto.req.MqMessage;

import java.util.List;

/**
 * 消费者拉取
 */
public class MqConsumerPullResp extends MqCommonResp {

    /**
     * 消息列表
     */
    private List<MqMessage> list;

    public List<MqMessage> getList() {
        return list;
    }

    public void setList(List<MqMessage> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MqConsumerPullResp{" +
                "list=" + list +
                "} " + super.toString();
    }

}
