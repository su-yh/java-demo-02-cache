package com.suyh0201.business.entity.mysql.business;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author suyh
 * @since 2025-07-31
 */
@Data
@TableName(value = "sys_menu", autoResultMap = true)
public class CacheMenuEntity {
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    private String menuName;

    private String menuKey;

    private Long parentId;
}
