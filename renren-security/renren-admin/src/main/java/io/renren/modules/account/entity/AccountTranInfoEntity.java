package io.renren.modules.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
public class AccountTranInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long tranId;
	/**
	 * 项目专户id
	 */
	private Long accountId;
	/**
	 * 交易金额
	 */
	private BigDecimal tranMon;
	/**
	 * 专户余额
	 */
	private BigDecimal accountRemain;
	/**
	 * 交易状态
	 */
	private Integer tranState;
	/**
	 * 进账账号
	 */
	private String incomeAccountNo;
	/**
	 * 进账单位名称
	 */
	private String incomeUnitName;
	/**
	 * 出账批次号
	 */
	private String outcomeBatchNo;
	/**
	 * 记录登记时间
	 */
	private Date recordTime;
	/**
	 * 工资单开始时间
	 */
	private Date payslipBeginTime;
	/**
	 * 工资单结束时间
	 */
	private Date payslipEndTime;
	/**
	 * 上传人id
	 */
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	private Date createTime;

}
