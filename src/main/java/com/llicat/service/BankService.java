package com.llicat.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * @author: lipan
 * @date: 2021/2/28 18:37
 */

@Service
public class BankService {


    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public int readAccount(Long id){
        System.out.println("aaa");

        return 0;
    }

    @Secured("ROLE_TELLER")
    public void post(){
        System.out.println("com.llicat.service.BankService.post");
}

}
