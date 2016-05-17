package com.gigold.pay.demo.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.facade.PubMsgServiceFacade;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.service.AbstractService;

/**
 * 非dubbo的service 都继承AbstractService
 *
 */
@Service
public class PubMsgIntegration extends AbstractService {

	@Reference
	public PubMsgServiceFacade pubMsgServiceFacade;

	public List getMsgInfo(String appId) throws PendingException {
		int count = -1;
		List resultList = new ArrayList();
		if (pubMsgServiceFacade != null) {
			try {
				resultList = pubMsgServiceFacade.getMsgInfo(appId);
			} catch (RpcException e) {
				debug(e.getCode() + "---->服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "服务不可用", e);
			} catch (Exception e) {
				debug("服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "其他异常", e);
			}
		} else {
			debug("服务不可用");
			count = -1;
			throw new PendingException(SysCode.RPC_FAIL, "服务不可用");

		}
		return resultList;
	}

	public int updateMsgInfo(String appId) throws PendingException {
		int count = -1;
		if (pubMsgServiceFacade != null) {
			try {
				count = pubMsgServiceFacade.updateMsgInfo(appId);
			} catch (RpcException e) {
				debug(e.getCode() + "---->服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "服务不可用", e);
			} catch (Exception e) {
				debug("服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "其他异常", e);
			}
		} else {
			debug("服务不可用");
			count = -1;
			throw new PendingException(SysCode.RPC_FAIL, "服务不可用");

		}
		return count;
	}

	public int insertMsgInfo(String appId) throws PendingException {
		int count = -1;
		if (pubMsgServiceFacade != null) {
			try {
				// count = pubMsgServiceFacade.insertMsgInfo(appId);
			} catch (RpcException e) {
				debug(e.getCode() + "---->服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "服务不可用", e);
			} catch (Exception e) {
				debug("服务不可用--- >" + e.getMessage());
				count = -1;
				throw new PendingException(SysCode.RPC_FAIL, "其他异常", e);
			}
		} else {
			debug("服务不可用");
			count = -1;
			throw new PendingException(SysCode.RPC_FAIL, "服务不可用");

		}
		return count;
	}
}
