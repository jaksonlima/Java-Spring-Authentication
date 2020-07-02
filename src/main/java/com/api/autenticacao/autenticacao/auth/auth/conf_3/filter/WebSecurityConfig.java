package com.api.autenticacao.autenticacao.auth.auth.conf_3.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PortalUserDetailsServiceImpl portalDetailsService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().disable();
        http.httpBasic().disable();
        http.csrf().disable();

//        http.authenticationProvider("").antMatcher("");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(portalDetailsService).userDetailsService(portalDetailsService).passwordEncoder(bCryptPasswordEncoder());
        auth.authenticationProvider(userDetailsService).userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterRegistrationBean authRequestFilterRegistration(AuthRequest_1 authRequest_1) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authRequest_1);
        registration.addUrlPatterns("/api/login/*");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean authRequest_2FilterRegistration(AuthRequest_2 authRequest_2) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(authRequest_2);
        registration.addUrlPatterns("/api/portal/login/*");
        registration.setOrder(2);
        return registration;
    }

}