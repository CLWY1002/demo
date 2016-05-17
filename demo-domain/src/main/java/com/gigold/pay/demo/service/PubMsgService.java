package com.gigold.pay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigold.pay.demo.dao.PubMsgDAO;
import com.gigold.pay.framework.base.dataroute.DataRoute;



@Service
public class PubMsgService {
	
	@Autowired
	private  PubMsgDAO pubMsgDAO;
	
	@DataRoute("configDataSource")
	public List getMsgInfo(String appId){
		
		return pubMsgDAO.getMsgInfo(appId);
		
	}

}
