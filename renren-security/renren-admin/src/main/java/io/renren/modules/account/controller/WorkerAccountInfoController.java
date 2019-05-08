package io.renren.modules.account.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.account.entity.WorkerAccountInfoEntity;
import io.renren.modules.account.service.WorkerAccountInfoService;
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
@RequestMapping("sys/workeraccountinfo")
public class WorkerAccountInfoController {
    @Autowired
    private WorkerAccountInfoService workerAccountInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:workeraccountinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workerAccountInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workerId}")
    @RequiresPermissions("sys:workeraccountinfo:info")
    public R info(@PathVariable("workerId") Long workerId){
        WorkerAccountInfoEntity workerAccountInfo = workerAccountInfoService.getById(workerId);

        return R.ok().put("workerAccountInfo", workerAccountInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:workeraccountinfo:save")
    public R save(@RequestBody WorkerAccountInfoEntity workerAccountInfo){
        workerAccountInfoService.save(workerAccountInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:workeraccountinfo:update")
    public R update(@RequestBody WorkerAccountInfoEntity workerAccountInfo){
        ValidatorUtils.validateEntity(workerAccountInfo);
        workerAccountInfoService.updateById(workerAccountInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:workeraccountinfo:delete")
    public R delete(@RequestBody Long[] workerIds){
        workerAccountInfoService.removeByIds(Arrays.asList(workerIds));

        return R.ok();
    }

}
