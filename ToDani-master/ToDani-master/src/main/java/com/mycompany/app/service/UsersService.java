package com.mycompany.app.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mycompany.app.config.JwtToken;
import com.mycompany.app.entity.Users;
import com.mycompany.app.record.Request.UsersLoginRequest;
import com.mycompany.app.record.Request.UsersRegisterRequest;
import com.mycompany.app.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@AllArgsConstructor
@Service

public class UsersService  {
    private final ResponeService responeService;
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Object UserRegisterService(UsersRegisterRequest usersRegisterRequest){
        try {
            Users usersData = usersRepository.findByUserName(usersRegisterRequest.UserName());

            if (usersData !=null) {System.out.print("IF "+usersData);
                return responeService.GetServiceObject(false,"Failed Register", null);
            } else {
                Users Emty = new Users();
                String encodedPassword = bCryptPasswordEncoder.encode(usersRegisterRequest.Password());

                Emty.setFullName(usersRegisterRequest.FullName());
                Emty.setUserName(usersRegisterRequest.UserName());
                Emty.setRoleId("0e9169c9-be01-48c4-9db0-b7d46a766c52");
                Emty.setPassword(encodedPassword);
                Emty.setCreatedAt(LocalDateTime.now());
                Users NewData = usersRepository.saveAndFlush(Emty);
                System.out.print("ELSE "+NewData.getUserId());
//                String Token = JwtToken.GenToken(String.valueOf(NewData.getUserId()));

                return responeService.GetServiceObject(true,"Successfully Register", NewData);
            }
        }catch(Exception e){
            return responeService.GetServiceObject(false,"Failed Register", null);
        }
    }

    public Object UserLoginService(UsersLoginRequest usersLoginRequest ){

        try {
            Users usersData = usersRepository.findByUserName(usersLoginRequest.UserName());
            if(usersData == null){
                return responeService.GetServiceObject(false,"Failed Login", null);
            }else {
//                usersData.getPassword();
                return responeService.GetServiceObject(true,"Successfully Login", usersData);
            }
        }catch(Exception e){
            return responeService.GetServiceObject(false,"Failed Login", null);
        }
    }


}
