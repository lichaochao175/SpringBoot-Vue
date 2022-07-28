package com.lcc.springbootvue.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/6/20 1:41 PM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    //@ApiModelProperty("菜单ID")
    private String id;
    /**
     *
     */
    private String name;
    //@ApiModelProperty("上级菜单ID")
    private String pId;
    //@ApiModelProperty("下级菜单集合")
    private List<Menu> children;
}
