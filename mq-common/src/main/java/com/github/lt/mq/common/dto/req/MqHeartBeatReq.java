package com.github.lt.mq.common.dto.req;


public class MqHeartBeatReq extends MqCommonReq {

    /**
     * address 信息
     */
    private String address;

    /**
     * 端口号
     */
    private int port;

    /**
     * 请求时间
     */
    private long time;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
