package com.suyh0201.sys.mapper.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.suyh.base.mp.mybatis.BaseMapperX;
import com.suyh0201.sys.constant.DataSourceNames;
import com.suyh0201.sys.entity.mysql.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Mapper
@DS(DataSourceNames.MASTER)
public interface SysUserMapper extends BaseMapperX<SysUserEntity> {
}
