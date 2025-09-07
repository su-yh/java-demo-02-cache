package com.suyh0201.cache.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author suyh
 * @since 2024-02-26
 */
@Component
@Slf4j
public class ExampleCaffeineComponent {
    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    // 缓存名称需要全局唯一：数据权限表缓存名，按每个id 进行缓存
    public static final String CACHE_NAME_DATA_PERMISSION_BY_ID = "DataPermissionById";
    // 缓存名称需要全局唯一：数据权限表缓存名，按每个parentId 进行缓存，该父id 对应的下级数据列表（不做递归处理）
    public static final String CACHE_NAME_DATA_PERMISSION_BY_PARENT_ID = "DataPermissionByParentId";
    // 缓存名称需要全局唯一：数据权限表缓存名，按每个permissionName 进行缓存
    public static final String CACHE_NAME_DATA_PERMISSION_BY_NAME = "DataPermissionByName";

    // 这个方法没有实际的业务意义，其作用是用来添理所有的缓存，需要把相关的缓存名称的都添加进来
    @Caching(evict = {
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_PARENT_ID, allEntries = true, cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_ID, allEntries = true, cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_NAME, allEntries = true, cacheManager = CAFFEINE_CACHE_MANAGER)
    })
    public void cleanAllCache() {
        // do nothing
    }

    @Nullable
    @Caching(cacheable = {
            // condition 参数，表达式结果为true 则正常执行缓存逻辑（查询缓存 → 未命中则执行方法 → 写入缓存），否则完全跳过缓存操作（直接执行方法，不查询也不写入缓存）
            // unless 参数，表达式结果为true 不写入缓存，否则写入缓存，在condition 执行之后
            @Cacheable(value = CACHE_NAME_DATA_PERMISSION_BY_ID, key = "#id", condition = "#id != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @Cacheable(value = CACHE_NAME_DATA_PERMISSION_BY_NAME, key = "#result.permissionName", condition = "#result != null && #result.permissionName != null", cacheManager = CAFFEINE_CACHE_MANAGER)
    })
    public Object selectEntityById(@Nullable Long id) {
        if (id == null) {
            return null;
        }

        return "";
    }

    /**
     * 因为更新所以需要清理缓存，这里不会有业务逻辑，只是需要清理相关缓存
     *
     * @param id                    更新实体对象的id
     * @param historyParentId       更新前的parentId
     * @param currentParentId       更新后的parentId
     * @param historyPermissionName 更新前的 permissionName
     * @param currentPermissionName 更新后的 permissionName
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_ID, key = "#id", condition = "#id != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_PARENT_ID, key = "#historyParentId", condition = "#historyParentId != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_PARENT_ID, key = "#currentParentId", condition = "#currentParentId != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_NAME, key = "#historyPermissionName", condition = "#historyPermissionName != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @CacheEvict(value = CACHE_NAME_DATA_PERMISSION_BY_NAME, key = "#currentPermissionName", condition = "#currentPermissionName != null", cacheManager = CAFFEINE_CACHE_MANAGER)
    })
    public void cacheEvict(
            @SuppressWarnings("unused") @Nullable Long id,
            @SuppressWarnings("unused") @Nullable Long historyParentId,
            @SuppressWarnings("unused") @Nullable Long currentParentId,
            @SuppressWarnings("unused") @Nullable String historyPermissionName,
            @SuppressWarnings("unused") @Nullable String currentPermissionName) {
        // do nothing
    }

    @NonNull
    // condition 参数，表达式结果为true 则正常执行缓存逻辑（查询缓存 → 未命中则执行方法 → 写入缓存），否则完全跳过缓存操作（直接执行方法，不查询也不写入缓存）
    // unless 参数，表达式结果为true 不写入缓存，否则写入缓存，在condition 执行之后
    @Cacheable(value = CACHE_NAME_DATA_PERMISSION_BY_PARENT_ID, key = "#parentId", condition = "#parentId != null", cacheManager = CAFFEINE_CACHE_MANAGER)
    public Collection<Object> selectListByParentId(@Nullable Long parentId) {

        return new ArrayList<>();
    }

    @Caching(cacheable = {
            // condition 参数，表达式结果为true 则正常执行缓存逻辑（查询缓存 → 未命中则执行方法 → 写入缓存），否则完全跳过缓存操作（直接执行方法，不查询也不写入缓存）
            // unless 参数，表达式结果为true 不写入缓存，否则写入缓存，在condition 执行之后
            @Cacheable(value = CACHE_NAME_DATA_PERMISSION_BY_ID, key = "#result.id", condition = "#result != null && #result.id != null", cacheManager = CAFFEINE_CACHE_MANAGER),
            @Cacheable(value = CACHE_NAME_DATA_PERMISSION_BY_NAME, key = "#name", condition = "#name != null", cacheManager = CAFFEINE_CACHE_MANAGER)
    })
    public Object selectEntityByName(String name) {
        return "";
    }
}
