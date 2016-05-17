package com.gigold.pay.demo.dao;



import org.apache.ibatis.annotations.Param;

import com.gigold.pay.demo.bo.FdcUpJrn;







public  interface FdcUpJrnDAO {


        
    public FdcUpJrn getFdcUpJrnById(@Param("id")String id) ;

  
   

}
