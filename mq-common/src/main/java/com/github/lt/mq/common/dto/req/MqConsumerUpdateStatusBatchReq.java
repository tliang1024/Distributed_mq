package com.github.lt.mq.common.dto.req;

import com.github.lt.mq.common.dto.req.component.MqConsumerUpdateStatusDto;

import java.util.List;

/**
 * 批量更新状态入参
 */
public class MqConsumerUpdateStatusBatchReq extends MqCommonReq {

    private List<MqConsumerUpdateStatusDto> statusList;

    public List<MqConsumerUpdateStatusDto> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<MqConsumerUpdateStatusDto> statusList) {
        this.statusList = statusList;
    }
}
