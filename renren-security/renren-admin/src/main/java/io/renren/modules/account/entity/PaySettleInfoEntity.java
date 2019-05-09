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
@TableName("pay_settle_info")
public class PaySettleInfoEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long seetleId;
	/**
	 * 项目编号
	 */
	private String proNo;
	/**
	 * 工人身份证号
	 */
	private String workerSfzh;
	/**
	 * 发放批次号
	 */
	private String grantBatchNo;
	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 工资发放日期
	 */
	private Date payGrantTime;
	/**
	 * 工资开始时间
	 */
	private Date payBeginTime;
	/**
	 * 工资截止时间
	 */
	private Date payEndTime;
	/**
	 * 应发工资
	 */
	private BigDecimal payTotal;
	/**
	 * 预发工资
	 */
	private BigDecimal payPrepare;
	/**
	 * 实发工资
	 */
	private BigDecimal payReal;
	/**
	 * 记录时间
	 */
	private Date recordTime;
	/**
	 * 工人银行卡号
	 */
	private String workerAccount;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 上传人
	 */
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	private Date createTime;

}
