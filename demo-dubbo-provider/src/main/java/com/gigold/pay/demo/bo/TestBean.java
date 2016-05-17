package com.gigold.pay.demo.bo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gigold.pay.framework.core.Domain;

/**
 * 所有的BO都继承 Domain
 * 
 *
 */
@Component
@Scope("prototype")
public class TestBean extends Domain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7231722110198054629L;

	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
