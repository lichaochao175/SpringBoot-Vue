package com.lcc.springbootvue.domain.entity;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lichaochao
 * @data 2022/6/20 1:54 PM
 **/
public class TestDemo {

    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new Menu("1", "一级", "0", null));
        menus.add(new Menu("2", "一级", "0", null));
        menus.add(new Menu("3", "一级", "0", null));
        menus.add(new Menu("4", "二级", "1", null));
        menus.add(new Menu("5", "二级", "1", null));
        menus.add(new Menu("6", "二级", "2", null));
        menus.add(new Menu("7", "三级", "4", null));
        menus.add(new Menu("8", "三级", "5", null));
        menus.add(new Menu("9", "三级", "6", null));
        menus.add(new Menu("10", "四级", "5", null));


        // 创建生成树的工具类，调用构造树方法得到树形菜单
        List<Menu> menuList = new MenuTree(menus).buildTree();

        // fastjson的JSON  将java对象转为JSON字符串
        String jsonString = JSON.toJSONString(menuList);
        System.out.println(jsonString);
    }
}