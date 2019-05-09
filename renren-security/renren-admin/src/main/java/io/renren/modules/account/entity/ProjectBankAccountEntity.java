package io.renren.modules.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
public class ProjectBankAccountEntity  implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long accountId;
	/**
	 * 企业统一社会信用代码
	 */
	private String busCode;
	/**
	 * 项目编号
	 */
	private String proNo;
	/**
	 * 开户行数据字典id
	 */
	private Long bankDicId;
	/**
	 * 工资专用账户账号
	 */
	private String accountNo;
	/**
	 * 专户开户户名
	 */
	private String accountName;
	/**
	 * 专户开户网点
	 */
	private String accountNet;
	/**
	 * 上传人id
	 */
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	private Date createTime;

}
