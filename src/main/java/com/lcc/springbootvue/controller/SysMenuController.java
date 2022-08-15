package com.lcc.springbootvue.controller;

import com.lcc.springbootvue.domain.entity.SysMenu;
import com.lcc.springbootvue.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lichaochao
 * @data 2022/5/13 1:42 PM
 **/
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
    @RequestMapping("getMeuns")
    public List<SysMenu> getAll(){
            return sysMenuMapper.selectList(null);
    }




}
