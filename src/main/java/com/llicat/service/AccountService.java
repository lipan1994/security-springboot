package com.llicat.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author: lipan
 * @date: 2021/2/28 20:09
 */

@Service
public class AccountService {



    @PreAuthorize("DGLD")
    public void post(){
        System.out.println("com.llicat.service.BankService.post");
    }

}
