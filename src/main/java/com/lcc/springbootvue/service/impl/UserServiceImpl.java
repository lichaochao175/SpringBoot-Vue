package com.lcc.springbootvue.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lcc.springbootvue.base.Resp;
import com.lcc.springbootvue.constant.enums.ResultCodeEnum;
import com.lcc.springbootvue.domain.entity.Role;
import com.lcc.springbootvue.domain.entity.SysRoleMenu;
import com.lcc.springbootvue.domain.entity.User;
import com.lcc.springbootvue.domain.dto.UserDto;
import com.lcc.springbootvue.mapper.RoleMapper;
import com.lcc.springbootvue.mapper.SysRoleMenuMapper;
import com.lcc.springbootvue.mapper.SysUserRoleMapper;
import com.lcc.springbootvue.mapper.UserMapper;
import com.lcc.springbootvue.service.UserService;
import com.lcc.springbootvue.utils.EncryptUtils;
import com.lcc.springbootvue.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author lichaochao
 * @data 2022/5/26 10:20 AM
 **/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    private final RoleMapper roleMapper;
    private SysUserRoleMapper  sysUserRoleMapper;

    private SysRoleMenuMapper   sysRoleMenuMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper, SysUserRoleMapper  sysUserRoleMapper, RoleMapper roleMapper, SysRoleMenuMapper   sysRoleMenuMapper) {
        this.userMapper = userMapper;
        this.sysUserRoleMapper= sysUserRoleMapper;
        this.roleMapper= roleMapper;
        this.sysRoleMenuMapper= sysRoleMenuMapper;
    }

    @Override
    public User getUserBymobile(String mobile) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public Resp checkUser(UserDto userDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",userDto.getMobile());
        User user = userMapper.selectOne(wrapper);
        log.info("获取到对象:{}",user);
        if(ObjectUtil.isEmpty(user)){
            return Resp.fail(ResultCodeEnum.UNAUTHORIZED,"对象为空");
        }
        if(!user.getPassword().equals(userDto.getPassword())){
            // 密码不一致
            return Resp.fail(ResultCodeEnum.UNAUTHORIZED,"密码错误");
        }
        return Resp.suc(user);
    }


    /**
     *  创建token
     * @param userDto
     * @return
     */
    public String login(UserDto userDto) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        User  user = userMapper.selectOne(wrapper.eq("mobile", userDto.getMobile()));
        //当对象
        Assert.notNull(user,"账户不存在");

        if(!EncryptUtils.validPassword(userDto.getPassword(),user.getPassword())){
            throw new IllegalArgumentException("账号密码错误");
        }
        //获取当前用户角色
        String roleName = roleMapper.selectOne(new QueryWrapper<Role>().eq("id", user.getRoleId())).getName();
        //获取当前角色下可以查看的菜单id
        List<Integer> ids = sysRoleMenuMapper.selectList(new QueryWrapper<SysRoleMenu>().eq("id", user.getRoleId()))
                .stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        String token = JWTUtil.sign(user.getMobile(),user.getUsername(), user.getRoleId(), ids);
        return token;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public Resp updateUser(User user){
        if (userMapper.updateById(user) > 0){
            return Resp.suc("修改成功") ;
        }
        return Resp.suc("修改失败") ;
    }
}
