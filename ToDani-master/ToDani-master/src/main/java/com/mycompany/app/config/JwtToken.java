package com.mycompany.app.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class JwtToken extends JWT {

    private static RSAPublicKey rsaPublicKey;
    private static RSAPrivateKey rsaPrivateKe;

    public static String GenToken(String Id){
        try {
            Algorithm algorithm = Algorithm.RSA256(rsaPublicKey, rsaPrivateKe);
            String token = JWT.create()
                    .withIssuer(Id)
                    .sign(algorithm);
            System.out.print("token" +token);
            return token;
        } catch (JWTCreationException exception){
            System.out.print("token" +Id);
            return "";
        }
    }
}
