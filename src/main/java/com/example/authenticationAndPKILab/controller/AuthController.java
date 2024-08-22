package com.example.authenticationAndPKILab.controller;

import com.example.authenticationAndPKILab.dto.LoginDataDto;
import com.example.authenticationAndPKILab.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final InMemoryUserDetailsManager userDetailsService;

    public AuthController(JwtUtil jwtUtil,  @Qualifier("userDetailsService") InMemoryUserDetailsManager userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDataDto loginDataDto) {
        System.out.println("Here exactly mn");
        try {
            new AuthenticationConfiguration().getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(loginDataDto.username(), loginDataDto.password())
            );
            System.out.println("Passed here");
        } catch (BadCredentialsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginDataDto.username());

        return jwtUtil.generateToken(userDetails);
    }
}
