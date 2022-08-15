package com.lcc.springbootvue.configuration;

import cn.hutool.core.codec.Base64;
import com.lcc.springbootvue.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Licc
 * @date 2022/7/31 11:03 AM
 */

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(securityManager);

        // 控制器中统一放回
        /**
         * 添加内置过滤器
         *  anon: 无需认证就可以访问
         *  authc: 必须认证才能访问
         *  perms: 拥有某个资源的权限才能访问
         *  role： 拥有某个权限才能访问
         */
        Map<String,String> filterMap = new HashMap<>();
        filterMap.put("/login.do","anon");
        filterMap.put("/test","anon");
        filterMap.put("/user/test","anon");
        filterMap.put("/user/login","anon");
        filterMap.put("/user/info","anon");
        filterMap.put("/product/cacheInser","anon");

        // 授权
        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/del", "perms[user:del]");
        //  未登入返回
        filterMap.put("/NotLoggedError", "anon");
        bean.setLoginUrl("/NotLoggedError");
        //  没有权限返回
        filterMap.put("/PermissionDeniedError", "anon");
        bean.setUnauthorizedUrl("/PermissionDeniedError");

        // Shiro自带的注销接口
        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    // DefaultWebsecurityManger
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UsesrRealm
        securityManager.setRealm(userRealm);
        // cookie
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }


    /**
     * cookie对象
     * @return
     */
    public SimpleCookie rememberMeCookie() {
        // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
        SimpleCookie cookie = new SimpleCookie("token");
        // 设置cookie的过期时间，单位为秒，这里为一天
        cookie.setMaxAge(86400);
        return cookie;
    }

    /**
     * cookie管理对象
     * @return
     */
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }
}