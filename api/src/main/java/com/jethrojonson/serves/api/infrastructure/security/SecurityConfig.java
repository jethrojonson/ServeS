package com.jethrojonson.serves.api.infrastructure.security;

import com.jethrojonson.serves.api.infrastructure.security.jwt.access.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final AccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        return authenticationManagerBuilder.authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //ADMIN
                .antMatchers(HttpMethod.POST, "/allergens/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/allergens/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/allergens/{id}").hasRole("ADMIN")
                //COMPANY
                .antMatchers(HttpMethod.PUT, "/company/{username}").hasRole("COMPANY")
                .antMatchers(HttpMethod.POST, "/company/{username}/products").hasRole("COMPANY")
                .antMatchers(HttpMethod.GET, "/company/{username}/products").hasRole("COMPANY")
                .antMatchers(HttpMethod.PUT, "/company/{username}/products/{productId}").hasRole("COMPANY")
                .antMatchers(HttpMethod.POST, "/company/{username}/categories").hasRole("COMPANY")
                //CUSTOMER
                .antMatchers(HttpMethod.PUT, "/customer/{username}").hasRole("CUSTOMER")
                //ALL
                .antMatchers(HttpMethod.GET,"/allergens/").permitAll()
                .antMatchers(HttpMethod.GET,"/allergens/{allergenId}").permitAll()

                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .headers().frameOptions().disable()
                .and()
                .build();
    }


    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().antMatchers(
                "/h2-console/**",
                "/swagger-ui/**", "/v3/api-docs/**",
                "/access/signup", "/access/login"
//                ,"/**"
        ));
    }

}
