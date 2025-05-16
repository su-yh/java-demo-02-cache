package com.suyh0201.business.config;

import com.suyh.base.web.response.BaseResponseBodyAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Configuration
public class BusinessConfiguration {
    @Bean
    public BaseResponseBodyAdvice baseResponseBodyAdvice() {
        List<String> basePackages = Arrays.asList("com.suyh0201.business.controller", "com.suyh0201.sys.controller");
        return new BaseResponseBodyAdvice(basePackages);
    }
}
