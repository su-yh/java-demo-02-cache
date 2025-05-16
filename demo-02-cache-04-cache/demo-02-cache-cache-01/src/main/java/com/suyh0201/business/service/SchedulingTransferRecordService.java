package com.suyh0201.business.service;

import com.suyh0201.business.entity.mysql.business.SchedulingTransferRecordEntity;
import com.suyh0201.business.mapper.mysql.business.SchedulingTransferRecordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulingTransferRecordService {
    private final SchedulingTransferRecordMapper schedulingTransferRecordMapper;

    @PostConstruct
    public void init() {
        List<SchedulingTransferRecordEntity> entities = schedulingTransferRecordMapper.selectList();
        log.info("size: {}", entities != null ? entities.size() : 0);
    }
}
