package com.lcc.springbootvue.domain.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lichaochao
 * @data 2022/6/20 1:42 PM
 **/
public class MenuTree {

    private static final long serialVersionUID = 1L;

    /**
     *承载菜单的列表
     */
    private List<Menu> menuList = new ArrayList<>();
    /***
     *   带参构造器，将数据库中的菜单数据记录，装载在我们承载菜单的列表中
     */
    public MenuTree(List<Menu> menuList){
        this.menuList = menuList;
    }

    /**
     * 获取根节点
     */
    public List<Menu> getRootNode() {
        List<Menu> rootNode = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getPId().equals("0")) {
                rootNode.add(menu);
            }
        }
        return rootNode;
    }

    /**
     *  构建子树
     */
    public Menu buildChildren(Menu rootNode){
        List<Menu> childreTree = new ArrayList<>();
         for (Menu menu: menuList){
             if(menu.getPId().equals(rootNode.getId())){
                 childreTree.add(menu);
             }
         }
         rootNode.setChildren(childreTree);
         return  rootNode;
    }

        // 构建树
        public List<Menu> buildTree () {
            //获取父节点
            List<Menu> menus = getRootNode();
            for (Menu menu : menus) {
                buildChildren(menu);
            }
            return menus;
        }

}
