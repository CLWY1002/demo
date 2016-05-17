package com.gigold.pay.demo.integration;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.facade.DubboServiceFacade;
import com.gigold.pay.demo.facade.XXXReqDto;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.service.AbstractService;

/**
 * 非dubbo的service 都继承AbstractService
 *
 */
@Service
public class DubboConsumerIntegration  extends AbstractService
{
    
	@Reference
	public DubboServiceFacade dubboService;
	
	public String sayHello(XXXReqDto reqDto) throws PendingException{
		String message=null;
		if (dubboService != null) {
			try {
				message=dubboService.hello(reqDto);
			}  catch (RpcException e) {
				debug(e.getCode()+"---->服务不可用--- >"+e.getMessage());
				throw new PendingException(SysCode.RPC_FAIL, "服务不可用", e);
			} catch (Exception e) {
				debug("服务不可用--- >"+e.getMessage());
				throw new PendingException(SysCode.RPC_FAIL, "其他异常", e);
			}
		} else {
			debug("服务不可用");
			throw new PendingException(SysCode.RPC_FAIL, "服务不可用");

		}
		return message;
	}
}
