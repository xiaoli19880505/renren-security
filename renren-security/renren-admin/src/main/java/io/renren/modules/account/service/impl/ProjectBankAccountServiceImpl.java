package io.renren.modules.account.service.impl;

import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.Constant;
import io.renren.modules.account.dao.ProjectBankAccountDao;
import io.renren.modules.account.entity.ProjectBankAccountEntity;
import io.renren.modules.account.service.ProjectBankAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;




@Service("projectBankAccountService")
public class ProjectBankAccountServiceImpl extends ServiceImpl<ProjectBankAccountDao, ProjectBankAccountEntity> implements ProjectBankAccountService {

    @Override
    @DataFilter(subDept = true, user = false,createDept = true)
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProjectBankAccountEntity> page = this.page(
                new Query<ProjectBankAccountEntity>().getPage(params),
                new QueryWrapper<ProjectBankAccountEntity>()
                        .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER))
        );
        return new PageUtils(page);
    }

    @Override
    @DataFilter(subDept = true, user = false,createDept = true)
    public List<ProjectBankAccountEntity> listNotPage(Map<String, Object> params) {
        return this.list(new QueryWrapper<ProjectBankAccountEntity>()
                .apply(params.get(Constant.SQL_FILTER) != null, (String)params.get(Constant.SQL_FILTER)));
    }

}
