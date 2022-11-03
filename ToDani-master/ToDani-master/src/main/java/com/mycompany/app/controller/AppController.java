package com.mycompany.app.controller;


import com.mycompany.app.record.Request.UsersLoginRequest;
import com.mycompany.app.record.Request.UsersRegisterRequest;
import com.mycompany.app.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("app")
public class AppController {
    private final UsersService usersService;
    @PostMapping("register")
    public Object RegisterController( @RequestBody(required = true) UsersRegisterRequest usersRegisterRequest) {
        return usersService.UserRegisterService(usersRegisterRequest);
    }
    @PostMapping("login")
    public Object LoginController( @RequestBody(required = true) UsersLoginRequest usersLoginRequest) {
        return usersService.UserLoginService(usersLoginRequest);
    }
}
