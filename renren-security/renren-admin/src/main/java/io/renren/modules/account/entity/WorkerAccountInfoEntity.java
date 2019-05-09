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
@TableName("worker_account_info")
@XmlRootElement(name="PersonBankAccount")
public class WorkerAccountInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@XmlTransient
	@TableId
	private Long workerId;
	/**
	 * 工人身份证号
	 */
	@XmlElement(name = "Zjhm",defaultValue = "",required = true ,nillable=false)
	private String workerSfzh;
	/**
	 * 开户行数据字典
	 */
	@XmlTransient
	private Long bankDicId;

	/**
	 * 银行编码
	 */
	@TableField(exist = false)
	@XmlElement(name = "BankCode",defaultValue = "")
	private String bankCode;


	/**
	 * 银行名称
	 */
	@TableField(exist = false)
	@XmlElement(name = "BankName",defaultValue = "")
	private String bankName;

	/**
	 * 工人开户账号
	 */
	@XmlElement(name = "PayAccount",defaultValue = "")
	private String workerAccountNo;
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
	public Long getWorkerId() {
		return workerId;
	}


	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}

	@XmlTransient
	public String getWorkerSfzh() {
		return workerSfzh;
	}

	public void setWorkerSfzh(String workerSfzh) {
		this.workerSfzh = workerSfzh;
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
	public String getWorkerAccountNo() {
		return workerAccountNo;
	}

	public void setWorkerAccountNo(String workerAccountNo) {
		this.workerAccountNo = workerAccountNo;
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
