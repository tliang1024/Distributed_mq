package com.github.lt.mq.common.support.hook;

import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;

/**
 * rpc 关闭 hook
 * （1）可以添加对应的 hook 管理类
 */
public abstract class AbstractShutdownHook implements RpcShutdownHook {

    /**
     * AbstractShutdownHook logger
     */
    private static final Log LOG = LogFactory.getLog(AbstractShutdownHook.class);

    @Override
    public void hook() {
        LOG.info("[Shutdown Hook] start");
        this.doHook();
        LOG.info("[Shutdown Hook] end");
    }

    /**
     * 执行 hook 操作
     */
    protected abstract void doHook();

}
