/**
 * Title: DemoDubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gigold.pay.demo.bo.Person;
import com.gigold.pay.demo.rpc.IDemoDubboService;
import com.gigold.pay.demo.rpc.UserListResDto;
import com.gigold.pay.demo.service.DemoService;
import com.gigold.pay.framework.base.DomainUtils;
import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.core.exception.PendingException;
import com.gigold.pay.framework.rpc.service.AbstractDubboService;
import com.github.pagehelper.PageInfo;

/**
 * Title: DemoDubboService<br/>
 * Description: 对外封装的SOA服务，接口只传递基本类型：String，Integer,Long,Float等<br/>
 * Company: gigold<br/>
 * 
 * @author Devin
 * @date 2015年9月28日下午1:13:54
 *
 */

@Service
public class DemoDubboFacade extends AbstractDubboService implements IDemoDubboService {

    @Autowired
    private DemoService service;

    public String sayHello(String name) throws AbortException {

        Person u1 = new Person();
        // u1.setName(name);
        u1.setDesc("ddd");
        u1.setAge(20);
        service.addPerson(u1);
        return "SUCESS";
    }

    public UserListResDto getUsers() throws PendingException {
        PageInfo<Person> list = service.queryPage(0);
        PageInfo result = DomainUtils.BO2DTO(list);
        UserListResDto dto = new UserListResDto();
        dto.setPageInfo(result);
        return dto;

    }

    public String sayHello2(String name) throws PendingException {
        throw new PendingException(CodeItem._FAIL, "ssss");
    }

}
