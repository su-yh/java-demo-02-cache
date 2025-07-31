package com.suyh0201.business.component;


import com.suyh0201.Suyh0201Application;
import com.suyh0201.business.entity.mysql.business.CacheMenuEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * @author suyh
 * @since 2025-07-31
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = Suyh0201Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class CacheMenuComponentTest {
    @Resource
    private CacheMenuComponent cacheMenuComponent;

    /**
     * 测试不同的缓存名称之间是独立的，主要是看日志。
     */
    @Test
    public void testSelectByI2() {
        cacheMenuComponent.selectById(1L);
        cacheMenuComponent.selectById(1L);
        cacheMenuComponent.selectById(1L);
        cacheMenuComponent.selectById2(1L);
        cacheMenuComponent.selectById2(1L);
        cacheMenuComponent.selectById2(1L);
    }

    @Test
    public void testSelectByIdNull() {
        cacheMenuComponent.selectById(null);
        cacheMenuComponent.selectById(null);
        cacheMenuComponent.selectById(null);
        cacheMenuComponent.selectById(null);
    }

    @Test
    public void testSelectById() {
        cacheMenuComponent.selectById(1L);
        cacheMenuComponent.selectById(1L);
        cacheMenuComponent.selectById(1L);
    }

    @Test
    public void testUpdateByIdNull() {
        cacheMenuComponent.updateById(null);
        cacheMenuComponent.updateById(new CacheMenuEntity());
    }

    @Test
    public void testUpdateById() {
        Long id = 1L;

        {
            cacheMenuComponent.selectById(id);
            cacheMenuComponent.selectById(id);
            CacheMenuEntity cacheMenuEntity = cacheMenuComponent.selectById(id);
            Assertions.assertNotNull(cacheMenuEntity);
            Assertions.assertEquals("routes.agentManage", cacheMenuEntity.getMenuKey());

            cacheMenuEntity.setMenuKey("suyhupdatekey");
            cacheMenuComponent.updateById(cacheMenuEntity);
        }

        {
            cacheMenuComponent.selectById(id);
            cacheMenuComponent.selectById(id);
            cacheMenuComponent.selectById(id);
            CacheMenuEntity cacheMenuEntity = cacheMenuComponent.selectById(id);
            Assertions.assertNotNull(cacheMenuEntity);
            Assertions.assertEquals("suyhupdatekey", cacheMenuEntity.getMenuKey());
        }

        {
            // 还原数据
            cacheMenuComponent.selectById(id);
            cacheMenuComponent.selectById(id);
            CacheMenuEntity cacheMenuEntity = cacheMenuComponent.selectById(id);
            cacheMenuEntity.setMenuKey("routes.agentManage");
            cacheMenuComponent.updateById(cacheMenuEntity);
        }
    }
}

