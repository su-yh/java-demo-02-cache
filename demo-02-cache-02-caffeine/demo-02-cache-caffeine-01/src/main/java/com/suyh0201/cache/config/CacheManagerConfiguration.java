package com.suyh0201.cache.config;

import com.suyh0201.cache.component.ExampleCaffeineComponent;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suyh
 * @since 2025-07-31
 */
@Configuration
@EnableCaching
public class CacheManagerConfiguration {

    @Bean(name = ExampleCaffeineComponent.CAFFEINE_CACHE_MANAGER)
    public CacheManager caffeineCacheManager() {
        /**
         * base.cache.caffeine.spec = "initialCapacity=32, maximumSize=50000, expireAfterAccess=1h"
         * 不要配置(refreshAfterWrite=10m)，因为没有 CacheLoader
         */
        String spec = "initialCapacity=32, maximumSize=50000, expireAfterAccess=1h";
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheSpecification(spec);

        return cacheManager;
    }
}
