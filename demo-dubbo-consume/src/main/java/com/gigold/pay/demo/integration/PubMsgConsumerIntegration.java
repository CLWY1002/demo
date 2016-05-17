package com.gigold.pay.demo.integration;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gigold.pay.demo.facade.PubMsgServiceFacade;
import com.gigold.pay.framework.service.AbstractService;

@Service
public class PubMsgConsumerIntegration extends AbstractService {
	@Reference
	PubMsgServiceFacade pubMsgServiceFacade;

	public List getMsgInfo(String appId) {
		List list = pubMsgServiceFacade.getMsgInfo("ALL");
		System.out.println(list.size());
		debug("测试");
		return list;
	}
}
