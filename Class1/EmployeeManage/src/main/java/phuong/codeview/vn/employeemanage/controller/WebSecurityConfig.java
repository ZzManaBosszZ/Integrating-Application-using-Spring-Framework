package phuong.codeview.vn.employeemanage.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import phuong.codeview.vn.employeemanage.service.MyUserDetailService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    private MyUserDetailService myUserDetailService; ;

    @Bean
    public DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, HttpServletResponse httpServletResponse) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->{
            registry.requestMatchers("users/list", "register/user").permitAll();
            registry.requestMatchers("users/edit").hasRole("ADMIN");
            registry.requestMatchers("users/add").hasRole("ADMIN");
            registry.requestMatchers("users/showFormForUpdate").hasRole("ADMIN");
            registry.requestMatchers("users/save").hasRole("ADMIN");
            registry.requestMatchers("users/delete").hasRole("ADMIN");
            registry.requestMatchers("users/search").permitAll();
            registry.anyRequest().authenticated();
        })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails Admin = User.builder()
//                .username("phuong")
//                .password("$2a$12$fh7Vfh1mZr/hS7h9phPi4eIjQFgiHlSjwIWOQqhgljcDkVVXn8jlm")
//                .roles("Admin")
//                .build();
//        return new InMemoryUserDetailsManager(Admin);
//    }

        @Bean
    public UserDetailsService userDetailsService() {
        return myUserDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
