package com.suyh0201.mp.mysql.mapper.business;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.suyh0201.datasource.constants.DataSourceNames;
import com.suyh0201.mp.mybatis.BaseMapperX;
import com.suyh0201.mp.mysql.entity.business.SchedulingTransferRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suyh
 * @since 2024-09-02
 */
@Mapper
@DS(DataSourceNames.MASTER)
public interface SchedulingTransferRecordMapper extends BaseMapperX<SchedulingTransferRecordEntity> {
}
