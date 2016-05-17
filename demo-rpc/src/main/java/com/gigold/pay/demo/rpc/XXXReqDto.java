/**
 * Title: XXXReqDTO.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.rpc;

import com.gigold.pay.framework.core.RequestDto;
import com.gigold.pay.framework.core.exception.OtherExceptionCollect;

/**
 * Title: XXXReqDTO<br/>
 * Description: rpc包依赖的发送的DTO，不要依赖bo包中的对象，最好都是基本类型组成<br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年10月29日上午10:01:49
 *
 */
public class XXXReqDto extends RequestDto{

	/* （non Javadoc）
	 * Title: validate<br/>
	 * <p>Description: <br/>
	 * @return
	 * @throws OtherExceptionCollect
	 * @see com.gigold.pay.framework.core.RequestDto#validate()
	 */
	@Override
	public boolean validate() throws OtherExceptionCollect {
		// TODO Auto-generated method stub
		return false;
	}

}
