package com.gigold.pay.demo.facade;

import com.alibaba.dubbo.rpc.RpcException;

public interface HelloServiceFacade {
    public String hello(XXXReqDto reqDto) throws RpcException;

}
