package com.goit.eugene.to_do_list.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

   private final DataSource dataSource;
    private static final String BY_USERNAME_QUERY = "SELECT username, password, enabled FROM users WHERE username=?";
    private static final String BY_USERNAME_ROLE_QUERY = "SELECT username, role FROM users WHERE username=?";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth ->
                        auth.requestMatchers("/note/list/**")
                                .hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/registration")
                                .permitAll()
                                .requestMatchers("/admin/users-list")
                                .hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/note/list", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .dataSource(dataSource)
                .usersByUsernameQuery(BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(BY_USERNAME_ROLE_QUERY)
                .passwordEncoder(new BCryptPasswordEncoder());

    }
}
