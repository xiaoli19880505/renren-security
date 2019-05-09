package io.renren.modules.account.entity;

import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;
import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {
    /**
     * 上传人id
     */
    private Long createPersonId;
    /**
     * 上传时间
     */
    private Date createTime;

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
        SysUserEntity sysUserEntity = ShiroUtils.getUserEntity();
        this.createPersonId=sysUserEntity.getUserId();
        this.createTime=new Date();
    }

}
