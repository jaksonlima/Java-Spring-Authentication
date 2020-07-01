package com.api.autenticacao.autenticacao.auth.conf_3.reactive;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

//    ReactiveAuthenticationManager customersAuthenticationManager() {
//        return authentication -> customer(authentication)
//                .switchIfEmpty(Mono.error(new UsernameNotFoundException(/*principal name*/)))
//                .map(b -> new UsernamePasswordAuthenticationToken(/*credentials*/));
//    }

}
