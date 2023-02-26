package com.github.lt.mq.common.util;

import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.github.lt.mq.common.resp.MqCommonRespCode;
import com.github.lt.mq.common.resp.MqException;
import com.github.lt.mq.common.rpc.RpcAddress;
import com.github.lt.mq.common.rpc.RpcChannelFuture;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class ChannelFutureUtils {

    private static final Log log = LogFactory.getLog(ChannelFutureUtils.class);

    /**
     * 初始化列表
     * @param brokerAddress 地址
     * @param channelHandler 处理类
     * @param check 是否检测可用性
     * @return 结果
     * @since 0.0.4
     */
    public static List<RpcChannelFuture> initChannelFutureList(final String brokerAddress,
                                                               final ChannelHandler channelHandler,
                                                               final boolean check) {
        List<RpcAddress> addressList = InnerAddressUtils.initAddressList(brokerAddress);

        List<RpcChannelFuture> list = new ArrayList<>();
        for(RpcAddress rpcAddress : addressList) {
            try {
                final String address = rpcAddress.getAddress();
                final int port = rpcAddress.getPort();

                EventLoopGroup workerGroup = new NioEventLoopGroup();
                Bootstrap bootstrap = new Bootstrap();
                ChannelFuture channelFuture = bootstrap.group(workerGroup)
                        .channel(NioSocketChannel.class)
                        .option(ChannelOption.SO_KEEPALIVE, true)
                        .handler(new ChannelInitializer<Channel>(){
                            @Override
                            protected void initChannel(Channel ch) throws Exception {
                                ch.pipeline()
                                        .addLast(new LoggingHandler(LogLevel.INFO))
                                        .addLast(channelHandler);
                            }
                        })
                        .connect(address, port)
                        .syncUninterruptibly();

                log.info("启动客户端完成，监听 address: {}, port：{}", address, port);

                RpcChannelFuture rpcChannelFuture = new RpcChannelFuture();
                rpcChannelFuture.setChannelFuture(channelFuture);
                rpcChannelFuture.setAddress(address);
                rpcChannelFuture.setPort(port);
                rpcChannelFuture.setWeight(rpcAddress.getWeight());
                list.add(rpcChannelFuture);
            } catch (Exception exception) {
                log.error("注册到 broker 服务端异常", exception);
                if(check) {
                    throw new MqException(MqCommonRespCode.REGISTER_TO_BROKER_FAILED);
                }
            }
        }

        if(check
            && CollectionUtil.isEmpty(list)) {
            log.error("check=true 且可用列表为空，启动失败。");
            throw new MqException(MqCommonRespCode.REGISTER_TO_BROKER_FAILED);
        }
        return list;
    }

}
