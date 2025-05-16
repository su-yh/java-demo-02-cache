package com.suyh0201.sys.component;

import com.suyh0201.sys.entity.mysql.SysUserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author suyh
 * @since 2025-05-16
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class SysPermissionService {
    public Set<String> getMenuPermission(SysUserEntity user) {
        // TODO: suyh - 菜单权限
        return new HashSet<>();
    }
}
