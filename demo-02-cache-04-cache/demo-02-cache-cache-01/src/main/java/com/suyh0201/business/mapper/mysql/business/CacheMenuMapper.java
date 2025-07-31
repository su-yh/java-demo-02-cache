package com.suyh0201.business.mapper.mysql.business;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.base.mp.mybatis.BaseMapperX;
import com.suyh0201.business.entity.mysql.business.CacheMenuEntity;
import com.suyh0201.sys.constant.DataSourceNames;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suyh
 * @since 2025-07-31
 */
@Mapper
@DS(DataSourceNames.MASTER)
public interface CacheMenuMapper extends BaseMapperX<CacheMenuEntity> {
}
