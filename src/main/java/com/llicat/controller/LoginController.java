package com.llicat.controller;

import com.llicat.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: lipan
 * @date: 2021/2/17 21:24
 */
@RestController
public class LoginController {

    @Autowired
    BankService bankService;

    @RequestMapping(value = "/login-success", produces = {"text/plain;charset=UTF-8"})
    public String loginSuccess() {
        String username=getUsername();
        return username+" 登录成功";
    }



    //spring-security的会话管理
    private String getUsername() {

        //封装了登录信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.isAuthenticated()){
            return null;
        }

        Object principal = authentication.getPrincipal();

        //UserDetailsService 会返回UserDetails

        if(principal instanceof UserDetails){

            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();

    }


    /*** 测试资源1 * @param session * @return */
    @GetMapping(value = "/r/r1", produces = {"text/plain;charset=UTF-8"})
    public String r1(HttpSession session) {

        return  "访问资源1";
    }


    /*** 测试资源2 * @param session * @return */
    @GetMapping(value = "/r/r2", produces = {"text/plain;charset=UTF-8"})
    public String r2(HttpSession session) {

        return  "访问资源2";
    }

    /*** 测试资源3 * @param session * @return */
    @GetMapping(value = "/r/r3", produces = {"text/plain;charset=UTF-8"})
    public String r3(HttpSession session) {

        return  "访问资源3";
    }

    @GetMapping(value = "/r/r4", produces = {"text/plain;charset=UTF-8"})
    public String r4(HttpSession session) {

        return  "访问资源4";
    }


    @GetMapping(value = "/m/m1", produces = {"text/plain;charset=UTF-8"})
    public String m1(HttpSession session) {
        bankService.readAccount(1L);
        bankService.post();
        return  "访问资源m1";
    }
}
