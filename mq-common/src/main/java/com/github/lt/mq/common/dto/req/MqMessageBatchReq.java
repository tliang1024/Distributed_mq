package com.github.lt.mq.common.dto.req;

import java.util.List;

public class MqMessageBatchReq extends MqCommonReq {

    private List<MqMessage> mqMessageList;

    public List<MqMessage> getMqMessageList() {
        return mqMessageList;
    }

    public void setMqMessageList(List<MqMessage> mqMessageList) {
        this.mqMessageList = mqMessageList;
    }
}
