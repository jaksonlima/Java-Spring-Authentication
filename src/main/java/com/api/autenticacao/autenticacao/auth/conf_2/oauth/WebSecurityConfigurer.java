package com.api.autenticacao.autenticacao.auth.conf_2.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;

import javax.servlet.http.HttpServletRequest;

//@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer()
                .authenticationManagerResolver(resolver());
    }

    AuthenticationFilter authenticationFilter() {
        AuthenticationFilter filter = new AuthenticationFilter(resolver(), new BasicAuthenticationConverter());
        filter.setSuccessHandler((request, response, auth) -> {
        });
        return filter;
    }

    AuthenticationManagerResolver<HttpServletRequest> resolver() {
        return request -> {
            if (request.getServletPath().startsWith("/empregado")) {
                return empregadoAuthenticationManager();
            }
            return clienteAuthenticationManager();
        };
    }

    AuthenticationManager clienteAuthenticationManager() {
        return authentication -> {
            if (isCustomer(authentication)) {
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
            }
            throw new UsernameNotFoundException(authentication.getName());
        };
    }

    AuthenticationManager empregadoAuthenticationManager() {
        return authentication -> {
            if (isEmployee(authentication)) {
                return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials());
            }
            throw new UsernameNotFoundException(authentication.getName());
        };
    }

    private boolean isCustomer(Authentication authentication) {
        return (authentication.getPrincipal().toString().startsWith("cliente"));
    }

    private boolean isEmployee(Authentication authentication) {
        return (authentication.getPrincipal().toString().startsWith("empregado"));
    }
}
