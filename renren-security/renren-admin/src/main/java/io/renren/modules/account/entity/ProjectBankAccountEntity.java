package io.renren.modules.account.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@TableName("project_bank_account")
@XmlRootElement(name="BankAccount")
public class ProjectBankAccountEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	@XmlTransient
	private Long accountId;
	/**
	 * 企业统一社会信用代码
	 */
	@XmlElement(name = "Qyzzjgdm")
	private String busCode;
	/**
	 * 项目编号
	 */
	@XmlElement(name = "PrjHtbaNum")
	private String proNo;
	/**
	 * 开户行数据字典id
	 */
	@XmlTransient
	private Long bankDicId;

	/**
	 * 银行编码
	 */
	@TableField(exist = false)
	@XmlElement(name = "BankCode")
	private String bankCode;


	/**
	 * 银行名称
	 */
	@TableField(exist = false)
	@XmlElement(name = "BankName")
	private String bankName;

	/**
	 * 工资专用账户账号
	 */
	@XmlElement(name = "PayAccount")
	private String accountNo;
	/**
	 * 专户开户户名
	 */
	@XmlElement(name = "BankHm")
	private String accountName;
	/**
	 * 专户开户网点
	 */
	@XmlElement(name = "BankWd")
	private String accountNet;
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
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@XmlTransient
	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	@XmlTransient
	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	@XmlTransient
	public Long getBankDicId() {
		return bankDicId;
	}

	public void setBankDicId(Long bankDicId) {
		this.bankDicId = bankDicId;
	}

	@XmlTransient
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@XmlTransient
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@XmlTransient
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@XmlTransient
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@XmlTransient
	public String getAccountNet() {
		return accountNet;
	}

	public void setAccountNet(String accountNet) {
		this.accountNet = accountNet;
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
