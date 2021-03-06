package io.renren.modules.account.service.impl;

import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.modules.account.dao.PaySettleInfoDao;
import io.renren.modules.account.entity.PaySettleInfoEntity;
import io.renren.modules.account.service.PaySettleInfoService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;




@Service("paySettleInfoService")
public class PaySettleInfoServiceImpl extends ServiceImpl<PaySettleInfoDao, PaySettleInfoEntity> implements PaySettleInfoService {

    @Override
    @DataFilter(subDept = true, user = false,createDept = true)
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PaySettleInfoEntity> page = this.page(
                new Query<PaySettleInfoEntity>().getPage(params),
                new QueryWrapper<PaySettleInfoEntity>()
                        .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

}
