//package com.example.authenticationAndPKILab.service;
//
//import com.example.authenticationAndPKILab.utils.JwtUtil;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService implements AuthenticationManager {
//    private final InMemoryUserDetailsManager userDetailsService;
//    private final JwtUtil jwtUtil;
//    private AuthenticationManager authenticationManager;
//
//    public AuthService(AuthenticationManager authenticationManager, @Qualifier("userDetailsService") InMemoryUserDetailsManager userDetailsService, JwtUtil jwtUtil) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        return null;
//    }
//
//
//    public String authenticate(String username, String password) throws Exception {
////        try {
////            authenticationManager.authenticate(
////                    new UsernamePasswordAuthenticationToken(username, password)
////            );
////        } catch (BadCredentialsException e) {
////            throw new Exception("Incorrect username or password", e);
////        }
////
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////        final String jwt = jwtUtil.generateToken(userDetails);
////
////        return jwt;
//
//    }
//}
