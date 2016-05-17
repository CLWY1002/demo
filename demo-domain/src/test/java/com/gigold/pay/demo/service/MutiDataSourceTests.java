package com.gigold.pay.demo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gigold.pay.demo.bo.FdcUpJrn;
import com.gigold.pay.demo.dao.FdcUpJrnDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/spring/*Beans.xml"})
public class MutiDataSourceTests {
	
	
	@Autowired
	private FdcUpJrnDAO fdcUpJrnDAO;
	
	
	@Autowired
	private PubMsgService pubMsgService;

	@Test
	public void testInitDao(){
		
		assertNotNull(fdcUpJrnDAO);
		FdcUpJrn fdcUpJrn = fdcUpJrnDAO.getFdcUpJrnById("1");
		assertNotNull(fdcUpJrn);
		assertNotNull(pubMsgService.getMsgInfo("FDC"));
		
		
		
		
	}
}
