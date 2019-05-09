package io.renren.modules.account.controller;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.common.annotation.SysLog;
import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.account.entity.AccountTranInfoEntity;
import io.renren.modules.account.entity.ProjectBankAccountEntity;
import io.renren.modules.account.service.ProjectBankAccountService;
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
@RequestMapping("sys/projectbankaccount")
public class ProjectBankAccountController {
    @Autowired
    private ProjectBankAccountService projectBankAccountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:projectbankaccount:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectBankAccountService.queryPage(params);
        return R.ok().put("page", page);
    }

    /**
     * 不分页查询列表
     */
    @RequestMapping("/alllist")
    @RequiresPermissions("sys:projectbankaccount:list")
    public R listNotPage(){
       // PageUtils page = projectBankAccountService.queryPage(params);
        List<ProjectBankAccountEntity> list = projectBankAccountService.listNotPage(new HashMap<String,Object>());
        return R.ok().put("list", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{accountId}")
    @RequiresPermissions("sys:projectbankaccount:info")
    public R info(@PathVariable("accountId") Long accountId){
        ProjectBankAccountEntity projectBankAccount = projectBankAccountService.getById(accountId);

        return R.ok().put("projectBankAccount", projectBankAccount);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:projectbankaccount:save")
    @SysLog("保存配置")
    public R save(@RequestBody ProjectBankAccountEntity projectBankAccount){
        String xmlStr = BankUtil.BeanToXml(projectBankAccount,ProjectBankAccountEntity.class);
        String resultMsg = BankUtil.uploadBankData("uploadBankAccount",xmlStr);
        /*上传成功，则插入数据*/
        if(resultMsg.indexOf("100")!=-1){
            /*设置上传人的id和上传时间*/
            SysUserEntity sysUserEntity = ShiroUtils.getUserEntity();
            projectBankAccount.setCreatePersonId(sysUserEntity.getUserId());
            projectBankAccount.setCreateTime(new Date());
            projectBankAccountService.save(projectBankAccount);
            return R.ok();}
        else{
            return R.error(resultMsg.split(";")[2]);
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:projectbankaccount:update")
    public R update(@RequestBody ProjectBankAccountEntity projectBankAccount){
        ValidatorUtils.validateEntity(projectBankAccount);
        projectBankAccountService.updateById(projectBankAccount);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:projectbankaccount:delete")
    public R delete(@RequestBody Long[] accountIds){
        projectBankAccountService.removeByIds(Arrays.asList(accountIds));

        return R.ok();
    }

}
