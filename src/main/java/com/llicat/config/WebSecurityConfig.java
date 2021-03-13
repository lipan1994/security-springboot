package com.llicat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: lipan
 * @date: 2021/2/17 20:45
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 定义用户信息
     * @return
     */
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService(){
//
//        InMemoryUserDetailsManager userDetailsManager=new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
//        userDetailsManager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
//        return userDetailsManager;
//    }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //访问 /r/**资源需要登录认证，其他资源放开，允许表单登录，登录成功跳转/login-success
          http.csrf().disable()//禁用csrf
                .authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1") //p1权限可以访问 r/r1
                .antMatchers("/r/r2").hasAnyAuthority("p2") //p2权限可以访问 r/r2
                .antMatchers("/r/r3").access("hasAuthority('p1') and hasAuthority('p2')") //有p1与p2才能访问 r3
                .antMatchers("/r/**") //r/** 只要通过认证就能访问
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login-view") //配置登录页面的请求地址
                .loginProcessingUrl("/login") //登录页面表单提交的请求地址（login.jsp提交地址）
                .successForwardUrl("/login-success") //登录成功访问的资源
                .permitAll(); //允许所有用户验证
    }



}

