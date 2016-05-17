/**
 * Title: DubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.service;

import com.alibaba.dubbo.rpc.RpcException;
import com.gigold.pay.demo.bo.TestBean;
import com.gigold.pay.demo.facade.DubboServiceFacade;
import com.gigold.pay.demo.facade.XXXReqDto;
import com.gigold.pay.framework.base.SpringContextHolder;
import com.gigold.pay.framework.rpc.service.AbstractDubboService;

/**
 * Title: DubboService<br/>
 * Description: Dubbo的service 都继承AbstractDubboService<br/>
 * Company: gigold<br/>
 * 
 * @author xiebin
 * @date 2016年1月14日下午9:15:06
 *
 */
public class DubboServiceImpl extends AbstractDubboService implements DubboServiceFacade {

	/*
	 * （non Javadoc） Title: hello<br/> <p>Description: <br/>
	 * 
	 * @return
	 * 
	 * @see com.gigold.pay.demo.rpc.IDubboService#hello()
	 */
	@Override
	public String hello(XXXReqDto reqDto) throws RpcException {
		debug("－－－－－－－－－－－－调用 hello －－－－－－－－－－－－－－－－－");

		if (reqDto == null) {
			debug("reqDto 为空");
			return "hello dubbo";
		}

		if (!reqDto.validate()) {
			debug("reqDto 验证不能通过");
			return "hello dubbo";
		}
		
		TestBean testBean = (TestBean) SpringContextHolder.getBean(TestBean.class);
		testBean.setInfo(reqDto.getInfo());
		
		return "hello dubbo--->" + testBean.getInfo();
	}

}
