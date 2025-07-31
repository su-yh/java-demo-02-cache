package com.suyh0201.business.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author suyh
 * @since 2025-07-31
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfiguration {
    public static final String MENU_CACHE_BEAN_NAME = "caffeineCacheManager";

    @Bean
    public Caffeine<Object, Object> caffeineLongKeyConfig() {
        return Caffeine.newBuilder().maximumSize(10000).expireAfterWrite(60, TimeUnit.MINUTES).initialCapacity(128);
    }

    @Bean(name = MENU_CACHE_BEAN_NAME)
    public CacheManager caffeineCacheManager(Caffeine<Object, Object> caffeine) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}
