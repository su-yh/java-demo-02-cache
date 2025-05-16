package com.suyh0201.business.mapper.mysql.audit;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.suyh0201.datasource.constants.DataSourceNames;
import com.suyh0201.mp.mybatis.BaseMapperX;
import com.suyh0201.business.entity.mysql.audit.OperationRecordEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suyh
 * @since 2024-09-02
 */
@Mapper
@DS(DataSourceNames.MASTER)
public interface OperationRecordMapper extends BaseMapperX<OperationRecordEntity> {
}
