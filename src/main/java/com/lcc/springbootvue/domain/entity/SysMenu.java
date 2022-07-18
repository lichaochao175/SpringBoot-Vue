package com.lcc.springbootvue.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_menu
 * @author 
 */
@Data
public class SysMenu implements Serializable {
    private Long id;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 前端URL
     */
    private String path;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序值
     */
    private Integer sortOrder;

    /**
     * 缓冲 0-开启，1- 关闭
     */
    private String keepAlive;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;

    /**
     * 逻辑删除标记(0--正常 1--删除)
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}