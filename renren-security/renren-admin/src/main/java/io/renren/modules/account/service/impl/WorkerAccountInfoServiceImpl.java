package io.renren.modules.account.service.impl;

import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.modules.account.dao.WorkerAccountInfoDao;
import io.renren.modules.account.entity.WorkerAccountInfoEntity;
import io.renren.modules.account.service.WorkerAccountInfoService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("workerAccountInfoService")
public class WorkerAccountInfoServiceImpl extends ServiceImpl<WorkerAccountInfoDao, WorkerAccountInfoEntity> implements WorkerAccountInfoService {

    @Override
    @DataFilter(subDept = true, user = false,createDept = true)
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WorkerAccountInfoEntity> page = this.page(
                new Query<WorkerAccountInfoEntity>().getPage(params),
                new QueryWrapper<WorkerAccountInfoEntity>()
                        .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );

        return new PageUtils(page);
    }

}
