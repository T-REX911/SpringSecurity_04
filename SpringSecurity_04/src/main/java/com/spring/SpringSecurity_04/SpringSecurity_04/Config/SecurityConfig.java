package com.spring.SpringSecurity_04.SpringSecurity_04.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // JDBC-based user details service
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/product/create").hasAnyRole("ADMIN", "MANAGER")
                        .requestMatchers("/product/update").hasAnyRole("ADMIN", "MANAGER", "CASHIER")
                        .requestMatchers("/product/delete").hasRole("ADMIN")
                        .requestMatchers("/product/read").hasAnyRole("ADMIN", "MANAGER", "CASHIER", "USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Use basic auth
        return http.build();
    }
}
