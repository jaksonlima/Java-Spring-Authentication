package com.api.autenticacao.autenticacao.auth.conf_2.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEmpregado {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/empregado")
    public ResponseEntity isAuthenticated() {
        return ResponseEntity.ok("Empregado!");
    }
}
