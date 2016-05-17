/**
 * Title: IDubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.rpc;

import com.alibaba.dubbo.rpc.RpcException;

/**
 * Title: IDubboService<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * @author xiebin
 * @date 2016年1月14日下午9:14:14
 *
 */
public interface DubboServiceFacade {

	
	public String hello() throws RpcException;
}
