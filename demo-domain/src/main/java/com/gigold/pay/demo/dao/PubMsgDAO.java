package com.gigold.pay.demo.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gigold.pay.framework.base.dataroute.DataRoute;





public  interface PubMsgDAO {


    public List getMsgInfo(@Param("appId")String appId) ;

   
   

}
