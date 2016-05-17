package com.gigold.pay.demo.service;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gigold.pay.demo.bo.FdcUpJrn;
import com.gigold.pay.framework.base.SpringContextHolder;

public class MutiDataSourceService {
	
	

	
	
	  public static void main(String[] args) {
	        try {
	            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/spring/*Beans.xml");
	            context.start();
	            FdcUpJrnService fcUpJrnService  = (FdcUpJrnService)SpringContextHolder.getBean("fdcUpJrnService");
	            PubMsgService pubMsgService  = (PubMsgService)SpringContextHolder.getBean("pubMsgService");
	            FdcUpJrn fdcUpJrn = fcUpJrnService.getFdcUpJrnById("1");	
	            for(int i=0;i<10;i++){
	              List list  = pubMsgService.getMsgInfo("FDC");
	            }
	            
	            
	        } catch (Exception e) {
	            
	            System.err.println("== start error==");
	            e.printStackTrace();
	        }
	    }

}
