package io.renren.modules.account.service.impl;

import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.modules.account.dao.AccountTranInfoDao;
import io.renren.modules.account.entity.AccountTranInfoEntity;
import io.renren.modules.account.service.AccountTranInfoService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;




@Service("accountTranInfoService")
public class AccountTranInfoServiceImpl extends ServiceImpl<AccountTranInfoDao, AccountTranInfoEntity> implements AccountTranInfoService {

    @Override
    @DataFilter(subDept = true, user = false,createDept = true)
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AccountTranInfoEntity> page = this.page(
                new Query<AccountTranInfoEntity>().getPage(params),
                new QueryWrapper<AccountTranInfoEntity>()
                        .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

}
