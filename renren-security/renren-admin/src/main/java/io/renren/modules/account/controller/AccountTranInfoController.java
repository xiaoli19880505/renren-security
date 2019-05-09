package io.renren.modules.account.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.renren.common.utils.Constant;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.account.entity.AccountTranInfoEntity;
import io.renren.modules.account.service.AccountTranInfoService;
import io.renren.modules.account.utils.BankUtil;
import io.renren.modules.sys.entity.SysUserEntity;
import io.renren.modules.sys.shiro.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-07 15:14:53
 */
@RestController
@RequestMapping("sys/accounttraninfo")
public class AccountTranInfoController {
    @Autowired
    private AccountTranInfoService accountTranInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:accounttraninfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountTranInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tranId}")
    @RequiresPermissions("sys:accounttraninfo:info")
    public R info(@PathVariable("tranId") Long tranId){
        AccountTranInfoEntity accountTranInfo = accountTranInfoService.getById(tranId);

        return R.ok().put("accountTranInfo", accountTranInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:accounttraninfo:save")
    public R save(@RequestBody AccountTranInfoEntity accountTranInfo){
        String xmlStr = BankUtil.BeanToXml(accountTranInfo,AccountTranInfoEntity.class);
        String resultMsg = BankUtil.uploadBankData("UploadBankAccount",xmlStr);
        /*上传成功，则插入数据*/
        if(resultMsg.indexOf("100")!=-1){
            /*设置上传人的id和上传时间*/
            SysUserEntity sysUserEntity = ShiroUtils.getUserEntity();
            accountTranInfo.setCreatePersonId(sysUserEntity.getUserId());
            accountTranInfo.setCreateTime(new Date());
            accountTranInfoService.save(accountTranInfo);
            return R.ok();
        }else{
           return R.error(resultMsg.split(";")[2]);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:accounttraninfo:update")
    public R update(@RequestBody AccountTranInfoEntity accountTranInfo){
        ValidatorUtils.validateEntity(accountTranInfo);
        accountTranInfoService.updateById(accountTranInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:accounttraninfo:delete")
    public R delete(@RequestBody Long[] tranIds){
        accountTranInfoService.removeByIds(Arrays.asList(tranIds));

        return R.ok();
    }

}
