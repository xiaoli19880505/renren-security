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
@TableName("account_tran_info")
@XmlRootElement(name = "SpecialAccount")
public class AccountTranInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	@XmlTransient
	private Long tranId;
	/**
	 * 项目专户id
	 */
	@XmlTransient
	private Long accountId;


	/**
	 * 项目编号
	 */
	@TableField(exist = false)
	@XmlElement(name = "PrjHtbaNum")
	private String proNo;

	/**
	 * 开户行名称
	 */
	@TableField(exist = false)
	@XmlElement(name = "BankName")
	private String bankName;

	/**
	 * 开户行编码
	 */
	@TableField(exist = false)
	@XmlElement(name = "AccountNum")
	private String bankNo;

	/**
	 * 交易金额
	 */
	@XmlElement(name = "Jyje")
	private BigDecimal tranMon;
	/**
	 * 专户余额
	 */
	@XmlElement(name = "Zhye")
	private BigDecimal accountRemain;
	/**
	 * 交易状态
	 */
	@XmlElement(name = "Jyzt")
	private Integer tranState;
	/**
	 * 进账账号
	 */
	@XmlElement(name = "Jzzh")
	private String incomeAccountNo;
	/**
	 * 进账单位名称
	 */
	@XmlElement(name = "Jzdw")
	private String incomeUnitName;
	/**
	 * 出账批次号
	 */
	@XmlElement(name = "Czpc")
	private String outcomeBatchNo;
	/**
	 * 记录登记时间
	 */
	@XmlElement(name = "Jldjsj")
	private Date recordTime;
	/**
	 * 工资单开始时间
	 */
	@XmlElement(name = "PayrollBeginDate")
	private Date payslipBeginTime;
	/**
	 * 工资单结束时间
	 */
	@XmlElement(name = "PayrollEndDate")
	private Date payslipEndTime;
	/**
	 * 上传人id
	 */
	@XmlTransient
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	@XmlTransient
	private Date createTime;


	@XmlTransient
	public Long getTranId() {
		return tranId;
	}

	public void setTranId(Long tranId) {
		this.tranId = tranId;
	}

	@XmlTransient
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@XmlTransient
	public BigDecimal getTranMon() {
		return tranMon;
	}

	public void setTranMon(BigDecimal tranMon) {
		this.tranMon = tranMon;
	}

	@XmlTransient
	public BigDecimal getAccountRemain() {
		return accountRemain;
	}

	public void setAccountRemain(BigDecimal accountRemain) {
		this.accountRemain = accountRemain;
	}

	@XmlTransient
	public Integer getTranState() {
		return tranState;
	}

	public void setTranState(Integer tranState) {
		this.tranState = tranState;
	}

	@XmlTransient
	public String getIncomeAccountNo() {
		return incomeAccountNo;
	}

	public void setIncomeAccountNo(String incomeAccountNo) {
		this.incomeAccountNo = incomeAccountNo;
	}

	@XmlTransient
	public String getIncomeUnitName() {
		return incomeUnitName;
	}

	public void setIncomeUnitName(String incomeUnitName) {
		this.incomeUnitName = incomeUnitName;
	}

	@XmlTransient
	public String getOutcomeBatchNo() {
		return outcomeBatchNo;
	}

	public void setOutcomeBatchNo(String outcomeBatchNo) {
		this.outcomeBatchNo = outcomeBatchNo;
	}

	@XmlTransient
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	@XmlTransient
	public Date getPayslipBeginTime() {
		return payslipBeginTime;
	}

	public void setPayslipBeginTime(Date payslipBeginTime) {
		this.payslipBeginTime = payslipBeginTime;
	}

	@XmlTransient
	public Date getPayslipEndTime() {
		return payslipEndTime;
	}

	public void setPayslipEndTime(Date payslipEndTime) {
		this.payslipEndTime = payslipEndTime;
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
