package io.renren.modules.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.account.entity.AccountTranInfoEntity;


import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-05-07 15:14:53
 */
public interface AccountTranInfoService extends IService<AccountTranInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

