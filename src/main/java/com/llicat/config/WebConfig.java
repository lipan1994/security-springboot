package com.llicat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author: lipan
 * @date: 2021/2/16 20:31
 * WebMvcConfigurer 此接口用来增加一些自定义的handler、interceptor、ViewReslover等，多用于springboot下的客户化
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 访问根路径重定向到/login资源 由springSecurity提供
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
         /**此为spring-security默认请求资源**/
//        registry.addViewController("/").setViewName("redirect:/login");

        //访问根目录 重定向到login-view视图 login-view 指向login
        registry.addViewController("/").setViewName("redirect:/login-view");
        registry.addViewController("/login-view").setViewName("login");
    }



}
