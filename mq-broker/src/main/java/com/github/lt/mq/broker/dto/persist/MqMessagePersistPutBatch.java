package com.github.lt.mq.broker.dto.persist;

import com.github.lt.mq.common.dto.req.MqMessage;
import com.github.lt.mq.common.rpc.RpcAddress;

import java.util.List;

public class MqMessagePersistPutBatch {

    /**
     * 消息体
     */
    private List<MqMessage> mqMessageList;

    /**
     * 地址信息
     */
    private RpcAddress rpcAddress;

    /**
     * 消息状态
     */
    private String messageStatus;

    public List<MqMessage> getMqMessageList() {
        return mqMessageList;
    }

    public void setMqMessageList(List<MqMessage> mqMessageList) {
        this.mqMessageList = mqMessageList;
    }

    public RpcAddress getRpcAddress() {
        return rpcAddress;
    }

    public void setRpcAddress(RpcAddress rpcAddress) {
        this.rpcAddress = rpcAddress;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
