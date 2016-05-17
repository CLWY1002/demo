/**
 * Title: DemoController.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gigold.pay.demo.integration.DubboConsumerIntegration;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.util.common.StringUtil;
import com.gigold.pay.framework.web.BaseController;



/**
 * Title: DemoController<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月16日下午6 :13:29
 */
public class DubboController extends BaseController {

    @Autowired
    private DubboConsumerIntegration dubboConsumerService;
    
    /**
     * Title: query<br/>
     * Description: <br/>
     * 
     * @author ousei
     * @date 2014年12月15日下午9:05:03
     *
     * @return ${返回信息描述}
     * @throws Exception
     */
//    @RequestMapping(value = "/query.do")
//    public @ResponseBody QueryDemoResDto query()  {
//        QueryDemoResDto res = new QueryDemoResDto();
//        debug("调用query：");
//        String message=dubboConsumerService.sayHello("dubbo");
//        if(StringUtil.isNotBlank(message)){
//        	res.setRspCd(SysCode.SUCCESS);
//        	res.setRspInf(message);
//        }else{
//        	res.setRspCd(SysCode.RPC_FAIL);
//        }
//        return res;
//    }
    
}

