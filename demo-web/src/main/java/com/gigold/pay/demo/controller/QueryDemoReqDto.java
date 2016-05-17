/**
 * Title: QueryDemoRequestDto.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.controller;

import com.gigold.pay.framework.core.RequestDto;
import com.github.pagehelper.PageInfo;

/**
 * Title: QueryDemoRequestDto<br/>
 * Description: 不应该依赖BO<br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月16日下午6:16:36
 *
 */
public class QueryDemoReqDto extends RequestDto{
    
    private String name;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

























    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

























    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

























    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

























    private String age;
    
    private PageInfo pageInfo;
   
    
    
    
    
    

   
    
   















    public boolean validate(){
      return true;
    }
}
