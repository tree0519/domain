package com.liu.domain.oauthserver.controller;

import com.liu.domain.oauthserver.service.AuthService;
import com.liu.domain.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 *
 * @author zyw
 * @date 2018/2/05
 */
@RestController
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;


    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/logout/removeToken")
    public void logOut(@RequestParam("username") String username){
        authService.cleanToken(username);
    }




}
