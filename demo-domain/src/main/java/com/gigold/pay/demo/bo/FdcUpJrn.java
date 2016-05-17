package com.gigold.pay.demo.bo;

import java.io.Serializable;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.gigold.pay.framework.core.Domain;

/**
 * Title: <br/>
 * Description: <br/>
 * Company: gigold<br/>
 * 
 * @author liwei
 * @date 2015年10月28日下午4:09:25
 *
 */
@Component
@Scope("prototype")
public class FdcUpJrn extends Domain implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	// 资金渠道流水号
	private String fdcJrnNo;
	// 金额
	private int amt;
	// 流水类型
	private String jrnType;
	// 币种
	private String currency;
	// 路由银行编码
	private String routeBankCode;
	// 原送往银联的流水
	private String orgSendBankJrnNo;
	// 送往银行的流水号
	private String sendBankJrnNo;
	// 银行返回的流水号
	private String rtnBankJrnNo;
	// 流水状态
	private String jrnStatus;
	// 银行返回编码
	private String rtnBankCode;
	// 银行返回信息描述
	private String rtnBankDesc;
	// 创建时间
	private Date tmCreate;
	// 完成时间
	private Date tmFinish;
	// 银行卡类型
	private String bankCardType;
	// 与账单关联结果
	private String acctRelResult;
	// 银行商户号
	private String bankMerId;
	// 银行清算日期
	private Date bankClearDt;
	// 银行清算币种
	private String bankClearCur;
	// 银行清算金额
	private int bankClearAmt;
	// 银行系统跟踪号
	private String bankTraceNo;
	// 交易传输日期
	private Date tmBankTrace;
	// 会计日期
	private String acDt;
	// 对账日期
	private String acctCmpDt;
	// 数据状态
	private String status;
	// 数据时间
	private Date tmSmp;
	// 银行返回tn
	private String bankTn;
	// 发起自动查询时间
	private Date tmNotify;
	// 发起次数
	private int notifyCount;
	// 银联返回银行卡号
	private String bankCardNo;

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFdcJrnNo() {
		return fdcJrnNo;
	}

	public void setFdcJrnNo(String fdcJrnNo) {
		this.fdcJrnNo = fdcJrnNo;
	}

	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}

	public String getJrnType() {
		return jrnType;
	}

	public void setJrnType(String jrnType) {
		this.jrnType = jrnType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRouteBankCode() {
		return routeBankCode;
	}

	public void setRouteBankCode(String routeBankCode) {
		this.routeBankCode = routeBankCode;
	}

	public String getOrgSendBankJrnNo() {
		return orgSendBankJrnNo;
	}

	public void setOrgSendBankJrnNo(String orgSendBankJrnNo) {
		this.orgSendBankJrnNo = orgSendBankJrnNo;
	}

	public String getSendBankJrnNo() {
		return sendBankJrnNo;
	}

	public void setSendBankJrnNo(String sendBankJrnNo) {
		this.sendBankJrnNo = sendBankJrnNo;
	}

	public String getRtnBankJrnNo() {
		return rtnBankJrnNo;
	}

	public void setRtnBankJrnNo(String rtnBankJrnNo) {
		this.rtnBankJrnNo = rtnBankJrnNo;
	}

	public String getJrnStatus() {
		return jrnStatus;
	}

	public void setJrnStatus(String jrnStatus) {
		this.jrnStatus = jrnStatus;
	}

	public String getRtnBankCode() {
		return rtnBankCode;
	}

	public void setRtnBankCode(String rtnBankCode) {
		this.rtnBankCode = rtnBankCode;
	}

	public String getRtnBankDesc() {
		return rtnBankDesc;
	}

	public void setRtnBankDesc(String rtnBankDesc) {
		this.rtnBankDesc = rtnBankDesc;
	}

	public Date getTmCreate() {
		return tmCreate;
	}

	public void setTmCreate(Date tmCreate) {
		this.tmCreate = tmCreate;
	}

	public Date getTmFinish() {
		return tmFinish;
	}

	public void setTmFinish(Date tmFinish) {
		this.tmFinish = tmFinish;
	}

	public String getBankCardType() {
		return bankCardType;
	}

	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}

	public String getAcctRelResult() {
		return acctRelResult;
	}

	public void setAcctRelResult(String acctRelResult) {
		this.acctRelResult = acctRelResult;
	}

	public String getBankMerId() {
		return bankMerId;
	}

	public void setBankMerId(String bankMerId) {
		this.bankMerId = bankMerId;
	}

	public Date getBankClearDt() {
		return bankClearDt;
	}

	public void setBankClearDt(Date bankClearDt) {
		this.bankClearDt = bankClearDt;
	}

	public String getBankClearCur() {
		return bankClearCur;
	}

	public void setBankClearCur(String bankClearCur) {
		this.bankClearCur = bankClearCur;
	}

	public int getBankClearAmt() {
		return bankClearAmt;
	}

	public void setBankClearAmt(int bankClearAmt) {
		this.bankClearAmt = bankClearAmt;
	}

	public String getBankTraceNo() {
		return bankTraceNo;
	}

	public void setBankTraceNo(String bankTraceNo) {
		this.bankTraceNo = bankTraceNo;
	}

	public Date getTmBankTrace() {
		return tmBankTrace;
	}

	public void setTmBankTrace(Date tmBankTrace) {
		this.tmBankTrace = tmBankTrace;
	}

	public String getAcDt() {
		return acDt;
	}

	public void setAcDt(String acDt) {
		this.acDt = acDt;
	}

	public String getAcctCmpDt() {
		return acctCmpDt;
	}

	public void setAcctCmpDt(String acctCmpDt) {
		this.acctCmpDt = acctCmpDt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTmSmp() {
		return tmSmp;
	}

	public void setTmSmp(Date tmSmp) {
		this.tmSmp = tmSmp;
	}

	public String getBankTn() {
		return bankTn;
	}

	public void setBankTn(String bankTn) {
		this.bankTn = bankTn;
	}

	public Date getTmNotify() {
		return tmNotify;
	}

	public void setTmNotify(Date tmNotify) {
		this.tmNotify = tmNotify;
	}

	public int getNotifyCount() {
		return notifyCount;
	}

	public void setNotifyCount(int notifyCount) {
		this.notifyCount = notifyCount;
	}

}
