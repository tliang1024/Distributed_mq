package com.github.lt.mq.producer.dto;

import com.github.lt.mq.producer.constant.SendStatus;

public class SendResult {

    /**
     * 消息唯一标识
     */
    private String messageId;

    /**
     * 发送状态
     */
    private SendStatus status;

    public static SendResult of(String messageId, SendStatus status) {
        SendResult result = new SendResult();
        result.setMessageId(messageId);
        result.setStatus(status);

        return result;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public SendStatus getStatus() {
        return status;
    }

    public void setStatus(SendStatus status) {
        this.status = status;
    }
}
