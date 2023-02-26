package com.github.lt.mq.common.constant;


public final class MessageStatusConst {

    private MessageStatusConst(){}

    /**
     * 待消费
     * ps: 生产者推送到 broker 的初始化状态
     */
    public static final String WAIT_CONSUMER = "W";

    /**
     * 推送给消费端处理中
     * ps: broker 准备推送时，首先将状态更新为 P，等待推送结果
     */
    public static final String TO_CONSUMER_PROCESS = "TCP";

    /**
     * 推送给消费端成功
     */
    public static final String TO_CONSUMER_SUCCESS = "TCS";

    /**
     * 推送给消费端失败
     */
    public static final String TO_CONSUMER_FAILED = "TCF";

    /**
     * 消费完成
     */
    public static final String CONSUMER_SUCCESS = "CS";

    /**
     * 消费失败
     */
    public static final String CONSUMER_FAILED = "CF";

    /**
     * 稍后消费
     */
    public static final String CONSUMER_LATER = "CL";

}
