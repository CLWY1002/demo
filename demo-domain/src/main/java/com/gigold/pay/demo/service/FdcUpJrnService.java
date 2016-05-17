package com.gigold.pay.demo.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigold.pay.demo.bo.FdcUpJrn;
import com.gigold.pay.demo.dao.FdcUpJrnDAO;

@Service
public class FdcUpJrnService {
	
	@Autowired
	private FdcUpJrnDAO   fdcUpJrnDAO;
	
	 public FdcUpJrn getFdcUpJrnById(String id){
		 return fdcUpJrnDAO.getFdcUpJrnById(id);
		 
	 }

}
