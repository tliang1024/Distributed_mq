package com.github.lt.mq.test.broker;

import com.github.lt.mq.broker.core.MqBroker;


public class BrokerMain {

    public static void main(String[] args) {
        MqBroker broker = new MqBroker();
        broker.start();
    }

}
