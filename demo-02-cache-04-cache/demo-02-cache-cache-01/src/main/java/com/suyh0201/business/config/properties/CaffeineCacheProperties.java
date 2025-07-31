package com.suyh0201.business.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author suyh
 * @since 2025-07-31
 */
@ConfigurationProperties("demo.cache")
@Validated
@Data
public class CaffeineCacheProperties {

    @NestedConfigurationProperty
    @Valid
    private final CaffeineProperties caffeine = new CaffeineProperties();

    @Data
    public static class CaffeineProperties {
        /**
         * base.cache.caffeine.spec = "initialCapacity=32, maximumSize=50000, expireAfterAccess=1h"
         * 不要配置(refreshAfterWrite=10m)，因为没有 CacheLoader
         */
        @NotBlank
        private String spec;
    }
}
