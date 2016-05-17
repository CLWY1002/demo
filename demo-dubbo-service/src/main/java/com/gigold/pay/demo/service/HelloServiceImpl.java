package com.gigold.pay.demo.service;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.facade.HelloServiceFacade;
import com.gigold.pay.demo.facade.XXXReqDto;
import com.gigold.pay.framework.rpc.service.AbstractDubboService;

@Service
public class HelloServiceImpl extends AbstractDubboService
        implements HelloServiceFacade {

    @Override
    public String hello(XXXReqDto reqDto) throws RpcException {
        if (reqDto == null) {
            debug("reqDto为空");
            return "reqDto为空";
        }
        if (!reqDto.validate()) {
            debug("reqDto校验不通过");
            return "reqDto校验不通过";
        }
        debug("hello ceshi");
        return "Hello,World! " + reqDto.getInfo();
    }
}
