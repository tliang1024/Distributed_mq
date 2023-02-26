package com.github.lt.mq.common.support.status;


public class StatusManager implements IStatusManager {

    private boolean status;

    private boolean initFailed;

    @Override
    public boolean status() {
        return this.status;
    }

    @Override
    public IStatusManager status(boolean status) {
        this.status = status;

        return this;
    }

    @Override
    public boolean initFailed() {
        return initFailed;
    }

    @Override
    public StatusManager initFailed(boolean initFailed) {
        this.initFailed = initFailed;
        return this;
    }
}
