package com.suyh0201.business.component;

import com.suyh0201.business.config.CaffeineCacheConfiguration;
import com.suyh0201.business.entity.mysql.business.CacheMenuEntity;
import com.suyh0201.business.mapper.mysql.business.CacheMenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author suyh
 * @since 2025-07-31
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CacheMenuComponent {
    public static final String CACHE_NAME = "MenuCaffeineCache";

    private final CacheMenuMapper cacheMenuMapper;

    // unless 参数，当返回值为null 时不做进行缓存，不过我觉得返回结果为null 也缓存起来是比较好的，因为当该值在后续变更成有值了之后，会将该缓存给清除掉，所以不影响结果。
    // condition 参数：当参数 id != null 时才进行缓存
    @Cacheable(value = CACHE_NAME, key = "#id", unless = "#result == null", condition = "#id != null", cacheManager = CaffeineCacheConfiguration.MENU_CACHE_BEAN_NAME)
    public CacheMenuEntity selectById(Long id) {
        log.info("select by id, from db, id: {}", id);
        if (id == null) {
            return null;
        }

        return cacheMenuMapper.selectById(id);
    }

    // 用来测试不同的缓存名称之间是独立的
    @Cacheable(value = CACHE_NAME + "2", key = "#id", unless = "#result == null", condition = "#id != null", cacheManager = CaffeineCacheConfiguration.MENU_CACHE_BEAN_NAME)
    public CacheMenuEntity selectById2(Long id) {
        return selectById(id);
    }

    @CacheEvict(value = CACHE_NAME, key = "#entity.menuId", condition = "#entity != null && #entity.menuId != null", cacheManager = CaffeineCacheConfiguration.MENU_CACHE_BEAN_NAME)
    public void updateById(CacheMenuEntity entity) {
        if (entity == null || entity.getMenuId() == null) {
            return;
        }

        cacheMenuMapper.updateById(entity);
    }

    @CacheEvict(value = CACHE_NAME, key = "#result", cacheManager = CaffeineCacheConfiguration.MENU_CACHE_BEAN_NAME)
    public Long create(CacheMenuEntity entity) {
        if (entity == null || entity.getMenuId() != null) {
            return null;
        }

        cacheMenuMapper.insert(entity);
        return entity.getMenuId();
    }
}
