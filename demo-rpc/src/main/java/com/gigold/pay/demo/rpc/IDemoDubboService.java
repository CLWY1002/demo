/**
 * Title: IDemoDubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.rpc;

import java.util.List;

import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.core.exception.PendingException;

/**
 * Title: IDemoDubboService<br/>
 * Description: 在申明接口时，最好附上对应的异常PendingException或AbortException，或两者都有
 * 参数为基本类型或定义在包内的Dto类，且这些Dto类不能依赖相关的BO<br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月28日下午1:17:39
 *
 */
public interface IDemoDubboService {
    
    public String sayHello(String name) throws AbortException;
    public UserListResDto getUsers()throws PendingException;
    public String sayHello2(String name) throws PendingException;
}
