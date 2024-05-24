package br.senac.tads.petshop.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import br.senac.tads.petshop.models.Cliente;;

@Service
public class TokenService {

    @Value("{api.security.token.secret}")
    private String secret;
    
    public String generateToken(Cliente users){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                            .withIssuer("mumus pet")
                            .withSubject(users.getEmail())
                            .withExpiresAt(genExpirationDate())
                            .sign(algorithm);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generation token", e);
        }
    }

    public String valideToken (String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("mumus pet")
                    .build()
                    .verify(token)
             //       .getClaim("role").asString()
                    .getSubject();

        }catch (JWTVerificationException e){
            return "";
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
