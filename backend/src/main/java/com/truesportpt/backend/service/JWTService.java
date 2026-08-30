package com.truesportpt.backend.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.oauth2.jwt.*;

import org.springframework.stereotype.Service;


@Service
public class JWTService {
    
    private final JwtEncoder jwtEncoder;

    public JWTService(JwtEncoder jwtEncoder)
    {
        this.jwtEncoder = jwtEncoder;
    }

    //Generated token will be tied to the user email
    public String generateToken(String email)
    {
        Instant i = Instant.now();
        
        JwtClaimsSet claim = JwtClaimsSet.builder()
            .issuer("truesportpt")
            .issuedAt(i)
            .expiresAt(i.plus(1, ChronoUnit.HOURS))
            .subject(email)
            .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claim))
                .getTokenValue();
    }
}
