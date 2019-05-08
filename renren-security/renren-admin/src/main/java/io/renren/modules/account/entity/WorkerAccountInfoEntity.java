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
@TableName("worker_account_info")
public class WorkerAccountInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Long workerId;
	/**
	 * 工人身份证号
	 */
	private String workerSfzh;
	/**
	 * 开户行数据字典
	 */
	private Long bankDicId;
	/**
	 * 工人开户账号
	 */
	private String workerAccountNo;
	/**
	 * 上传人
	 */
	private Long createPersonId;
	/**
	 * 上传时间
	 */
	private Date createTime;

}
