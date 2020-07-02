package com.api.autenticacao.autenticacao.auth.auth.conf_3.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PortalUserDetailsServiceImpl portalDetailsService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("/api/login")
    public ResponseEntity login() {
        PreAuthenticatedAuthenticationToken preAuthenticatedAuthenticationToken = new PreAuthenticatedAuthenticationToken("lima", "lima");

        authenticationManager.authenticate(preAuthenticatedAuthenticationToken);

        return ResponseEntity.ok("login usuario!");
    }

    @PostMapping("/api/portal/login")
    public ResponseEntity portalLogin() {
        authenticationManager.authenticate(portalDetailsService.usernamePasswordAuthenticationToken("lima", "lima"));

        return ResponseEntity.ok("login usuario portal!");
    }

}
