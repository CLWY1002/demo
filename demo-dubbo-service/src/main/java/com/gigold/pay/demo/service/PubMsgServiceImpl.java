package com.gigold.pay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;

import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.dao.PubMsgDAO;
import com.gigold.pay.demo.facade.PubMsgServiceFacade;
import com.gigold.pay.framework.base.dataroute.DataRoute;
import com.gigold.pay.framework.base.transaction.GigoldTransactionTemplate;
import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.rpc.service.AbstractDubboService;

@Service
public class PubMsgServiceImpl extends AbstractDubboService implements PubMsgServiceFacade {

	@Autowired
	private PubMsgDAO pubMsgDAO;
	@Autowired
	private GigoldTransactionTemplate newTransactionTemplate;

	@DataRoute("configDataSource")
	public List getMsgInfo(String appId) {
		List list = pubMsgDAO.getMsgInfo(appId);
		System.out.println("--------------size:" + list.size());
		return list;

	}

	@DataRoute("configDataSource")
	public Integer updateMsgInfo(final String appId) {
		// 事务模版开启事务
		Integer exCount = newTransactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status) {
				Integer count = -1;
				try {
					count = pubMsgDAO.updateMsgInfo(appId);
				} catch (AbortException ae) {
					warn("修改出错", ae);
					// 事务回滚
					status.setRollbackOnly();
					return -1;
				} catch (Exception e) {
					warn("修改出错", e);
					// 事务回滚
					status.setRollbackOnly();
					return -1;
				}
				return count;
			}
		});
		return exCount;
	}

	@DataRoute("configDataSource")
	public Integer insertMsgInfo(final String appId) throws RpcException {
		// 事务模版开启事务
		Integer exCount = newTransactionTemplate.execute(new TransactionCallback<Integer>() {
			public Integer doInTransaction(TransactionStatus status) {
				Integer count = -1;
				try {
					count = pubMsgDAO.updateMsgInfo(appId);
				} catch (AbortException ae) {
					warn("修改出错", ae);
					// 事务回滚
					status.setRollbackOnly();
					return -1;
				} catch (Exception e) {
					warn("修改出错", e);
					// 事务回滚
					status.setRollbackOnly();
					return -1;
				}
				return count;
			}
		});
		return exCount;
	}

}
