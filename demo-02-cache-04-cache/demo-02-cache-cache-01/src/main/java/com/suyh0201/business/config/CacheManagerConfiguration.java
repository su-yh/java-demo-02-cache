package com.suyh0201.business.config;

import com.suyh0201.business.config.properties.CaffeineCacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suyh
 * @since 2025-07-31
 */
@EnableConfigurationProperties(CaffeineCacheProperties.class)
@Configuration
@EnableCaching
public class CacheManagerConfiguration {
    public static final String MENU_CACHE_MANAGER = "menuCacheManager";

    @Bean(name = MENU_CACHE_MANAGER)
    public CacheManager caffeineCacheManager(CaffeineCacheProperties cacheProperties) {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheSpecification(cacheProperties.getCaffeine().getSpec());

        return cacheManager;
    }
}
