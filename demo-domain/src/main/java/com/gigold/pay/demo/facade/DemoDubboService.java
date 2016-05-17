/**
 * Title: DemoDubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.facade;

import org.springframework.stereotype.Service;

import com.gigold.pay.demo.rpc.IDemoDubboService;
import com.gigold.pay.demo.rpc.UserListResDto;
import com.gigold.pay.framework.core.exception.AbortException;
import com.gigold.pay.framework.core.exception.PendingException;

/**
 * Title: DemoDubboService<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author xiebin
 * @date 2016年1月12日下午4:47:43
 *
 */
@Service
public class DemoDubboService implements IDemoDubboService {

	/* （non Javadoc）
	 * Title: sayHello<br/>
	 * <p>Description: <br/>
	 * @param name
	 * @return
	 * @throws AbortException
	 * @see com.gigold.pay.demo.rpc.IDemoDubboService#sayHello(java.lang.String)
	 */
	public String sayHello(String name) throws AbortException {
		
		return "hello dubbo";
	}

	/* （non Javadoc）
	 * Title: getUsers<br/>
	 * <p>Description: <br/>
	 * @return
	 * @throws PendingException
	 * @see com.gigold.pay.demo.rpc.IDemoDubboService#getUsers()
	 */
	public UserListResDto getUsers() throws PendingException {
		return null;
	}

	/* （non Javadoc）
	 * Title: sayHello2<br/>
	 * <p>Description: <br/>
	 * @param name
	 * @return
	 * @throws PendingException
	 * @see com.gigold.pay.demo.rpc.IDemoDubboService#sayHello2(java.lang.String)
	 */
	public String sayHello2(String name) throws PendingException {
		 return "hello dubbo 222";
	}

}
