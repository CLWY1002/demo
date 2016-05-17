package com.gigold.pay.demo.integration;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.facade.HelloServiceFacade;
import com.gigold.pay.demo.facade.XXXReqDto;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.service.AbstractService;

@Service
public class HelloConsumerIntergration extends AbstractService {
    @Reference
    HelloServiceFacade helloService;

    public String hello(String msg) throws PendingException {
        XXXReqDto reqDto = new XXXReqDto();
        reqDto.setInfo(msg);
        try {
            return helloService.hello(reqDto);
        } catch (RpcException e) {
            debug(e.getCode() + "调用helloService异常：" + e.getMessage() + " 入参：" + reqDto);
            throw new PendingException(SysCode.RPC_FAIL, "服务不可用", e);
        } catch (Exception e) {
            debug("调用helloService异常：" + e.getMessage() + " 入参：" + reqDto);
            throw new PendingException(SysCode.RPC_FAIL, "其他异常", e);
        }
    }
}
