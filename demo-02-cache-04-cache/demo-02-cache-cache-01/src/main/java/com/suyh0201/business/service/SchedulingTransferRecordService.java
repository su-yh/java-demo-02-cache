package com.suyh0201.business.service;

import com.suyh0201.business.mapper.mysql.business.SchedulingTransferRecordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulingTransferRecordService {
    private final SchedulingTransferRecordMapper schedulingTransferRecordMapper;
}
