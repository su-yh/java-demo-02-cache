package com.suyh0201.sys.constant.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

/**
 * @author suyh
 * @since 2024-10-17
 */
@Getter
public enum OrderOriginEnums {
    @Schema(description = "1-短信")
    SMS(1),
    @Schema(description = "2-邮件")
    EMAIL(2),
    @Schema(description = "3-人工审核")
    HUMAN(3),
    ;

    @EnumValue
    private final int code;

    OrderOriginEnums(int code) {
        this.code = code;
    }
}
