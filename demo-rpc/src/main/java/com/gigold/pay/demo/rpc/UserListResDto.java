/**
 * Title: XXXResDto.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.rpc;

import com.gigold.pay.framework.core.ResponseDto;
import com.github.pagehelper.PageInfo;

/**
 * Title: UserListResDto<br/>
 * Description: rpc包依赖的发送的DTO，不要依赖bo包中的对象，最好都是基本类型组成<br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年10月29日上午10:02:23
 *
 */
public class UserListResDto extends ResponseDto{
    
    
    private PageInfo list;
    
    
    
    
    
    
    /**
     * @return the list
     */
    public PageInfo getList() {
        return list;
    }






    /**
     * @param list the list to set
     */
    public void setPageInfo(PageInfo list) {
        this.list = list;
    }


    
    


    
}
