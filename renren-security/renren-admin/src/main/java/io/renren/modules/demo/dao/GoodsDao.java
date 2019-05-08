package io.renren.modules.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.demo.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品管理
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-04-16 18:50:46
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
	
}
