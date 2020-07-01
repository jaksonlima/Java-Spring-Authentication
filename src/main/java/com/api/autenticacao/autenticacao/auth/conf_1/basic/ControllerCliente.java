package com.api.autenticacao.autenticacao.auth.conf_1.basic;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ControllerCliente {

    @GetMapping("/cliente")
    public ResponseEntity isAuthenticated() {
        return ResponseEntity.ok("Cliente!");
    }
}
