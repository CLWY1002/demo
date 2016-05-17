/**
 * Title: DemoController.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gigold.pay.demo.integration.DubboConsumerIntegration;
import com.gigold.pay.demo.integration.PubMsgIntegration;
import com.gigold.pay.framework.core.ResponseDto;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.web.BaseController;

/**
 * Title: DemoController<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * 
 * @author Devin
 * @date 2015年9月16日下午6 :13:29
 */
@Controller
@RequestMapping("/")
public class DubboController extends BaseController {

	@Autowired
	public DubboConsumerIntegration dubboConsumerIntegration;
	@Autowired
	public PubMsgIntegration pubMsgIntegration;

	/**
	 * 
	 * Title: query<br/>
	 * Description: 通过service包装一层来调用dubbo<br/>
	 * 
	 * @author xiebin
	 * @date 2016年1月15日上午11:42:08
	 * 
	 * @return
	 */
	@RequestMapping(value = "/insert.do")
	public @ResponseBody ResponseDto query(@RequestBody String req) {
		ResponseDto res = new ResponseDto();
		debug("调用insert-->入参：" + req);
		int count;
		try {
			count = pubMsgIntegration.insertMsgInfo(req);
			debug("调用Dubbo返回的信息－－－－－>" + count);
			res.setRspCd(SysCode.SUCCESS);
		} catch (PendingException e) {
			res.setRspCd(e.getCode());
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/get.do")
	public @ResponseBody ResponseDto getInfo() {
		ResponseDto res = new ResponseDto();
		debug("调用getInfo：");
		int count;
		try {
			List  resultList= pubMsgIntegration.getMsgInfo("11");
			debug("调用Dubbo返回的信息－－－－－>" + resultList);
			res.setRspCd(SysCode.SUCCESS);
			res.setDataes(resultList);
		} catch (PendingException e) {
			res.setRspCd(e.getCode());
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/update.do")
	public @ResponseBody ResponseDto update() {
		ResponseDto res = new ResponseDto();
		debug("调用update-->入参：");
		int count;
		try {
			count = pubMsgIntegration.updateMsgInfo("11");
			debug("调用Dubbo返回的信息－－－－－>" + count);
			res.setRspCd(SysCode.SUCCESS);
			List resultList = new ArrayList();
			resultList.add(count);
			res.setDataes(resultList);
		} catch (PendingException e) {
			res.setRspCd(e.getCode());
			e.printStackTrace();
		}
		return res;
	}
}
