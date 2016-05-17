/**
 * Title: DemoController.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gigold.pay.demo.bo.FdcUpJrn;
import com.gigold.pay.demo.bo.Person;
import com.gigold.pay.demo.service.DemoService;
import com.gigold.pay.demo.service.FdcUpJrnService;
import com.gigold.pay.demo.service.PubMsgService;
import com.gigold.pay.framework.base.DomainFactory;
import com.gigold.pay.framework.base.SpringContextHolder;
import com.gigold.pay.framework.cache.CacheFactory;
import com.gigold.pay.framework.core.ReqHeader;
import com.gigold.pay.framework.core.SysCode;
import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.web.BaseController;



/**
 * Title: DemoController<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月16日下午6 :13:29
 */
@Controller
@RequestMapping("/")
public class DemoController extends BaseController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private PubMsgService pubMsgService;
    @Autowired
    private FdcUpJrnService fdcUpJrnService;
    
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
    @RequestMapping(value = "/query.do")
    public @ResponseBody QueryDemoResDto query()  {
        QueryDemoResDto res = new QueryDemoResDto();
        debug("调用query：");
        FdcUpJrn fdcUpJrn = fdcUpJrnService.getFdcUpJrnById("1");
        List list  = pubMsgService.getMsgInfo("FDC");
        return res;
    }
    
    
//    @RequestMapping(value = "/query.do")
//    public @ResponseBody QueryDemoResDto query(@RequestBody QueryDemoReqDto dto)  {
//        QueryDemoResDto res = new QueryDemoResDto();
//        debug("调用query：");
//        //检查参数
//        if(!dto.validate()){
//            res.setRspCd(CodeItem.DEMO_FAIL);
//            return res;
//        }
//        try{
//            Person inputPerson = createBO(dto, Person.class);
//        
//            Person p=demoService.query(inputPerson);
//            debug("传入的参数"+dto.getName());
//            if(p!= null){
//                updateDTO(p,res);
//               
//                res.setRspCd(SysCode.SUCCESS);
//            }else{
//                res.setRspCd(CodeItem.DEMO_FAIL);
//            }
//        }catch(Exception e){
//            res.setRspCd(CodeItem.DEMO_FAIL);
//        }
//        return res;
//    }
    
    
    
    //演示http无参数情况
    @RequestMapping(value = "/query2.do")
    public @ResponseBody QueryDemoResDto query2()  {
        QueryDemoResDto res = new QueryDemoResDto();
        debug("调用query：");
        
        ReqHeader header =getHeader();
        debug("请求的Session ID＝"+header.getTokenId());
        Person input = new Person();
        input.setName("test");
        Person p=demoService.query(input);
        debug("传入的参数test");
        if(p!= null){
            res.updateDTO(p);
            res.setRspCd(SysCode.SUCCESS);
        }else{
            res.setRspCd(CodeItem.DEMO_FAIL);
        }
        return res;
    }
    
    //演示http无参数情况，且需要访问session的情况
    //事务成功，业务成功
    @RequestMapping(value = "/insert.do")
    public @ResponseBody QueryDemoResDto insert(HttpSession session)  {
        QueryDemoResDto res = new QueryDemoResDto();
        debug("调用insert：");
        session.setAttribute("test", "陈志铉");
        session.setAttribute("test1", "czx");
        Person p = DomainFactory.getInstance().getDomain(Person.class);
        p.setDesc("事务成功");
        
        try {
            demoService.addPerson(p);
            res.setRspCd(SysCode.SUCCESS);
        } catch (AbortException e) {
            res.setRspCd(SysCode.SYS_FAIL);
            
            e.catchLog(this.getClass(), SysCode.SYS_FAIL);
        }    
       
        return res;
    }
    
    //演示http GET 请求带参数情况，且需要访问session的情况
    @RequestMapping(value = "/get.do")
    public @ResponseBody QueryDemoResDto get(HttpSession session)  {
        QueryDemoResDto res = new QueryDemoResDto();
        debug("调用get：");
        try {
            String curAcDate = (String) CacheFactory.getCacheClient().get("sssss");
        } catch (PendingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String test = (String)session.getAttribute("test");
        String test1 = (String)session.getAttribute("test1");
        debug(test);
        debug(test1);
        
        res.setRspCd(SysCode.SUCCESS);
        
        return res;
    }

  //演示业务显示失败，业务成为失败，因为调用的服务没有配置响应的事务
    @RequestMapping(value = "/add.do")
    public @ResponseBody QueryDemoResDto add()  {
        debug("调用add：");
        Person p = DomainFactory.getInstance().getDomain(Person.class);
        p.setDesc("事务失败");
        QueryDemoResDto res = new QueryDemoResDto();
        try {
            demoService.addPersonFail(p);
            res.setRspCd(SysCode.SUCCESS);
        } catch (AbortException e) {
            res.setRspCd(SysCode.SYS_FAIL);
            e.catchLog(this.getClass(), SysCode.SYS_FAIL);
        }        
        return res;
    }
    
    
    
    //演示业务显示失败，但实际业务成功，因为调用的服务没有配置响应的事务
    @RequestMapping(value = "/add1.do")
    public @ResponseBody QueryDemoResDto add1()  {
        debug("调用add1：");
        Person p = DomainFactory.getInstance().getDomain(Person.class);
        debug("p in 容器"+p.getName());
        p.setDesc("事务成功");
        QueryDemoResDto res = new QueryDemoResDto();
        try {
            demoService.addPerson(p);
            res.setRspCd(SysCode.SUCCESS);
        } catch (AbortException e) {
            // TODO Auto-generated catch block          
            res.setRspCd(SysCode.SYS_FAIL);
            e.catchLog(this.getClass(), SysCode.SYS_FAIL);
        }        
        return res;
    }
    
    
  //演示业务显示失败，但实际业务成功，因为调用的服务随配置了事务，但并没有触发，因为异常为其他异常
    @RequestMapping(value = "/add2.do")
    public @ResponseBody QueryDemoResDto add2()  {
        debug("调用add1：");
        Person p = (Person) SpringContextHolder.getBean(Person.class);
        p.setDesc("事务成功");
        QueryDemoResDto res = new QueryDemoResDto();
        try {
            demoService.addPerson(p);
            res.setRspCd(SysCode.SUCCESS);
        } catch (AbortException e) {
            e.catchLog(this.getClass(), SysCode.SYS_FAIL);
            res.setRspCd(SysCode.SYS_FAIL);
        }        
        return res;
    }
    
    
  //演示业务触发数据库事务，违反唯一约束，导致自己回滚
    @RequestMapping(value = "/only.do")
    public @ResponseBody QueryDemoResDto only()  {
        debug("调用add1：");
        Person p = (Person) SpringContextHolder.getBean(Person.class);
        p.setName("我不能重复");
        p.setDesc("事务成功");
        QueryDemoResDto res = new QueryDemoResDto();
        try {
            demoService.addPerson(p);
            res.setRspCd(SysCode.SUCCESS);
        } catch (AbortException e) {
            e.catchLog(this.getClass(), SysCode.SYS_FAIL);
            res.setRspCd(SysCode.SYS_FAIL);
        }        
        return res;
    }


    /**
     * Sets demo service.
     *
     * @param demoService the demo service
     */
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }
}