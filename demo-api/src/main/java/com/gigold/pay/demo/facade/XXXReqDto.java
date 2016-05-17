/**
 * Title: XXXReqDTO.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.facade;

import com.gigold.pay.framework.core.RequestDto;
import com.gigold.pay.framework.core.exception.OtherExceptionCollect;

/**
 * Title: XXXReqDTO<br/>
 * Description: rpc包依赖的发送的DTO，不要依赖bo包中的对象，最好都是基本类型组成<br/>
 * Company: gigold<br/>
 *
 */
public class XXXReqDto extends RequestDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -459134275405730012L;

	private String info;
	
	
	
	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	/* （non Javadoc）
	 * Title: validate<br/>
	 * <p>Description: <br/>
	 * @return
	 * @throws OtherExceptionCollect
	 * @see com.gigold.pay.framework.core.RequestDto#validate()
	 */
	@Override
	public boolean validate() throws OtherExceptionCollect {
		return true;
	}

}
