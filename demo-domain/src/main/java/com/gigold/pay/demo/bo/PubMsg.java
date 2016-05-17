package com.gigold.pay.demo.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PubMsg {
	
	private String appId;

	private String msgCd;
	private String msgInf;
	
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMsgCd() {
		return msgCd;
	}
	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}
	public String getMsgInf() {
		return msgInf;
	}
	public void setMsgInf(String msgInf) {
		this.msgInf = msgInf;
	}

}
