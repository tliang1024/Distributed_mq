/*
 * Copyright (c)  2019. houbinbin Inc.
 * rpc All rights reserved.
 */

package com.github.lt.mq.broker.support.api;


import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.lt.mq.broker.api.IBrokerProducerService;
import com.github.lt.mq.broker.dto.BrokerServiceEntryChannel;
import com.github.lt.mq.broker.dto.ServiceEntry;
import com.github.lt.mq.broker.resp.MqBrokerRespCode;
import com.github.lt.mq.broker.utils.InnerChannelUtils;
import com.github.lt.mq.common.dto.resp.MqCommonResp;
import com.github.lt.mq.common.resp.MqCommonRespCode;
import com.github.lt.mq.common.resp.MqException;
import com.github.lt.mq.common.util.ChannelUtil;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> 生产者注册服务类 </p>
 */
public class LocalBrokerProducerService implements IBrokerProducerService {

    private static final Log log = LogFactory.getLog(LocalBrokerProducerService.class);

    private final Map<String, BrokerServiceEntryChannel> registerMap = new ConcurrentHashMap<>();

    @Override
    public MqCommonResp register(ServiceEntry serviceEntry, Channel channel) {
        final String channelId = ChannelUtil.getChannelId(channel);
        BrokerServiceEntryChannel entryChannel = InnerChannelUtils.buildEntryChannel(serviceEntry, channel);
        registerMap.put(channelId, entryChannel);


        MqCommonResp resp = new MqCommonResp();
        resp.setRespCode(MqCommonRespCode.SUCCESS.getCode());
        resp.setRespMessage(MqCommonRespCode.SUCCESS.getMsg());
        return resp;
    }

    @Override
    public MqCommonResp unRegister(ServiceEntry serviceEntry, Channel channel) {
        final String channelId = ChannelUtil.getChannelId(channel);
        registerMap.remove(channelId);

        MqCommonResp resp = new MqCommonResp();
        resp.setRespCode(MqCommonRespCode.SUCCESS.getCode());
        resp.setRespMessage(MqCommonRespCode.SUCCESS.getMsg());
        return resp;
    }

    @Override
    public ServiceEntry getServiceEntry(String channelId) {
        return registerMap.get(channelId);
    }

    @Override
    public void checkValid(String channelId) {
        if(!registerMap.containsKey(channelId)) {
            log.error("channelId: {} 未注册", channelId);
            throw new MqException(MqBrokerRespCode.P_REGISTER_CHANNEL_NOT_VALID);
        }
    }

}
