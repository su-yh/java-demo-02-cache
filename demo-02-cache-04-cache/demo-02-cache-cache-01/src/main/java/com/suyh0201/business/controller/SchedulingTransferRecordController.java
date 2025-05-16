package com.suyh0201.business.controller;

import com.suyh0201.business.service.SchedulingTransferRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Tag(name = "订单")
@RestController
@RequestMapping("/scheduling/transfer/record")
@RequiredArgsConstructor
@Validated
@Slf4j
public class SchedulingTransferRecordController {
    private final SchedulingTransferRecordService schedulingTransferRecordService;

}
