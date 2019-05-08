package io.renren.modules.account.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.common.validator.ValidatorUtils;
import io.renren.modules.account.entity.PaySettleInfoEntity;
import io.renren.modules.account.service.PaySettleInfoService;
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
@RequestMapping("sys/paysettleinfo")
public class PaySettleInfoController {
    @Autowired
    private PaySettleInfoService paySettleInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:paysettleinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = paySettleInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{seetleId}")
    @RequiresPermissions("sys:paysettleinfo:info")
    public R info(@PathVariable("seetleId") Long seetleId){
        PaySettleInfoEntity paySettleInfo = paySettleInfoService.getById(seetleId);

        return R.ok().put("paySettleInfo", paySettleInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:paysettleinfo:save")
    public R save(@RequestBody PaySettleInfoEntity paySettleInfo){
        paySettleInfoService.save(paySettleInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:paysettleinfo:update")
    public R update(@RequestBody PaySettleInfoEntity paySettleInfo){
        ValidatorUtils.validateEntity(paySettleInfo);
        paySettleInfoService.updateById(paySettleInfo);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:paysettleinfo:delete")
    public R delete(@RequestBody Long[] seetleIds){
        paySettleInfoService.removeByIds(Arrays.asList(seetleIds));

        return R.ok();
    }

}
