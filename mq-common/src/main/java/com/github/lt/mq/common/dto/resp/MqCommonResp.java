package com.github.lt.mq.common.dto.resp;

import java.io.Serializable;


public class MqCommonResp implements Serializable {

    /**
     * 响应编码
     */
    private String respCode;

    /**
     * 响应消息
     */
    private String respMessage;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
}
