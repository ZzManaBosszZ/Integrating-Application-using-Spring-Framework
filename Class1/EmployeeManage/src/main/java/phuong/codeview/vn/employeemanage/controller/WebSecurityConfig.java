package phuong.codeview.vn.employeemanage.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(registry ->{
            registry.requestMatchers("users/list").permitAll();
            registry.requestMatchers("users/add").permitAll();
            registry.requestMatchers("users/showFormForUpdate").permitAll();
            registry.requestMatchers("users/save").permitAll();
            registry.requestMatchers("users/delete").permitAll();
            registry.requestMatchers("users/search").permitAll();
//            registry.requestMatchers("login").permitAll();
            registry.anyRequest().authenticated();
        })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails Admin = User.builder()
                .username("phuong")
                .password("$2a$12$fh7Vfh1mZr/hS7h9phPi4eIjQFgiHlSjwIWOQqhgljcDkVVXn8jlm")
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(Admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
