/**
 * Title: DemoServiceImpl.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigold.pay.demo.bo.Person;
import com.gigold.pay.demo.dao.DemoDAO;
import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.core.exception.PendingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * Title: DemoServiceImpl<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月16日下午2:37:27
 *
 */
@Service
public class DemoService {

    @Autowired
    private DemoDAO dao;

    public Person query(Person person) {
        //逻辑处理
        if(person != null){
            return dao.search(person.getName());
        }else{
            return null;
        }
    }

    public PageInfo<Person> queryPage(int pageNum) {
        //逻辑处理
        //逻辑处理
        //逻辑处理
        PageHelper.startPage(pageNum, 2, true);
        List<Person> list = dao.searchALL();
        PageInfo<Person> pi = new PageInfo(list);
        return pi;
    }

    public Person queryForUpdate(Person person) {
        //逻辑处理
        //逻辑处理
        //逻辑处理
        if(person != null){
            return dao.searchForupdate(person.getName());
        }else{
            return null;
        }
    }

    public Long addPerson(Person p) throws AbortException {
        //逻辑处理
        //逻辑处理
        //逻辑处理
        
//        throw new AbortException(CodeItem._FAIL, "failed，but the data inserted");
//        throw new PendingException(CodeItem._FAIL,"failed，but the data inserted");
        return dao.addPerson(p);

    }

    public Long addPersonFail(Person p) throws AbortException {
        //逻辑处理
        //逻辑处理
        //逻辑处理
        
        return dao.addPerson(p);
        //        throw new AbortException(CodeItem._FAIL,"failed");
    }

    public boolean modifyPerson(Person p) throws AbortException {
        //逻辑处理
        //逻辑处理
        //逻辑处理
        
        return dao.modifyPerson(p);
    }


}
