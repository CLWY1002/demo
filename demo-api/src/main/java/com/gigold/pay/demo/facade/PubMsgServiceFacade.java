/**
 * Title: IDubboService.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.facade;

import java.util.List;

import com.alibaba.dubbo.rpc.RpcException;

/**
 * Title: IDubboService<br/>
 * Description: <br/>
 * Company: gigold<br/>
 * 
 * @author xiebin
 * @date 2016年1月14日下午9:14:14
 *
 */
public interface PubMsgServiceFacade {

	public List getMsgInfo(String appId) throws RpcException;

	public Integer updateMsgInfo(String appId) throws RpcException;

	public Integer insertMsgInfo(String appId) throws RpcException;

}
