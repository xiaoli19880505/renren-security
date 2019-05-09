package io.renren.modules.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-07 15:14:53
 */
@Data
@TableName("pay_settle_info")
@XmlRootElement(name = "Settlement")
public class PaySettleInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@TableField(exist = false)
	private Long seetleId;
	/**
	 * 项目编号
	 */
	@XmlElement(name = "PrjHtbaNum")
	private String proNo;
	/**
	 * 工人身份证号
	 */
	@XmlElement(name = "Zjhm")
	private String workerSfzh;
	/**
	 * 发放批次号
	 */
	@XmlElement(name = "Ffpc")
	private String grantBatchNo;
	/**
	 * 银行名称
	 */
	@XmlElement(name = "BankName")
	private String bankName;
	/**
	 * 工资发放日期
	 */
	@XmlElement(name = "PayrollDate")
	private Date payGrantTime;
	/**
	 * 工资开始时间
	 */
	@XmlElement(name = "PayrollBeginDate")
	private Date payBeginTime;
	/**
	 * 工资截止时间
	 */
	@XmlElement(name = "PayrollEndDate")
	private Date payEndTime;
	/**
	 * 应发工资
	 */
	@XmlElement(name = "TotalPay")
	private BigDecimal payTotal;
	/**
	 * 预发工资
	 */
	@XmlElement(name = "PreparePay")
	private BigDecimal payPrepare;
	/**
	 * 实发工资
	 */
	@XmlElement(name = "FeedbackPay")
	private BigDecimal payReal;
	/**
	 * 记录时间
	 */
	@XmlElement(name = "Jldjsj")
	private Date recordTime;
	/**
	 * 工人银行卡号
	 */
	@XmlElement(name = "WorkerAccount")
	private String workerAccount;
	/**
	 * 备注
	 */
	@XmlElement(name = "Bz")
	private String remark;
	/**
	 * 上传人
	 */
	@XmlTransient
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	@XmlTransient
	private Date createTime;

	@XmlTransient
	public Long getSeetleId() {
		return seetleId;
	}

	public void setSeetleId(Long seetleId) {
		this.seetleId = seetleId;
	}

	@XmlTransient
	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	@XmlTransient
	public String getWorkerSfzh() {
		return workerSfzh;
	}

	public void setWorkerSfzh(String workerSfzh) {
		this.workerSfzh = workerSfzh;
	}

	@XmlTransient
	public String getGrantBatchNo() {
		return grantBatchNo;
	}

	public void setGrantBatchNo(String grantBatchNo) {
		this.grantBatchNo = grantBatchNo;
	}

	@XmlTransient
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@XmlTransient
	public Date getPayGrantTime() {
		return payGrantTime;
	}

	public void setPayGrantTime(Date payGrantTime) {
		this.payGrantTime = payGrantTime;
	}

	@XmlTransient
	public Date getPayBeginTime() {
		return payBeginTime;
	}

	public void setPayBeginTime(Date payBeginTime) {
		this.payBeginTime = payBeginTime;
	}

	@XmlTransient
	public Date getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(Date payEndTime) {
		this.payEndTime = payEndTime;
	}

	@XmlTransient
	public BigDecimal getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(BigDecimal payTotal) {
		this.payTotal = payTotal;
	}

	@XmlTransient
	public BigDecimal getPayPrepare() {
		return payPrepare;
	}

	public void setPayPrepare(BigDecimal payPrepare) {
		this.payPrepare = payPrepare;
	}

	@XmlTransient
	public BigDecimal getPayReal() {
		return payReal;
	}

	public void setPayReal(BigDecimal payReal) {
		this.payReal = payReal;
	}

	@XmlTransient
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@XmlTransient
	public String getWorkerAccount() {
		return workerAccount;
	}

	public void setWorkerAccount(String workerAccount) {
		this.workerAccount = workerAccount;
	}

	@XmlTransient
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@XmlTransient
	public Long getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(Long createPersonId) {
		this.createPersonId = createPersonId;
	}

	@XmlTransient
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
