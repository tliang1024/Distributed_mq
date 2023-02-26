package com.github.lt.mq.broker.support.valid;

import com.github.lt.mq.broker.dto.BrokerRegisterReq;


public class BrokerRegisterValidService implements IBrokerRegisterValidService {

    @Override
    public boolean producerValid(BrokerRegisterReq registerReq) {
        return true;
    }

    @Override
    public boolean consumerValid(BrokerRegisterReq registerReq) {
        return true;
    }

}
