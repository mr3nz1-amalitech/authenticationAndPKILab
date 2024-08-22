package com.example.authenticationAndPKILab.config;

import com.example.authenticationAndPKILab.filter.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecConfig {
    private final JwtFilter jwtFilter;

    public WebSecConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails doctor = User
                .withUsername("doctor")
                .password(
                        passwordEncoder()
                                .encode("doctor")
                )
                .roles("DOCTOR").
                build();

        UserDetails patient = User
                .withUsername("patient").password(
                        passwordEncoder().encode("patient")
                )
                .roles("PATIENT")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(
                        passwordEncoder().encode("admin")
                )
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(doctor, patient, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/doctor/**").hasRole("DOCTOR")
                                .requestMatchers("/patient/**").hasRole("PATIENT")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/api/v1/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        form -> form.defaultSuccessUrl("/home", true)
                )
                .logout(config -> config.logoutUrl("/logout")).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
