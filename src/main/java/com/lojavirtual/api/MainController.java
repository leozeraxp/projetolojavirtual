package com.lojavirtual.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/")
    public ResponseEntity olaMundo(){
        return ResponseEntity.ok("Olá mundo!");
    }
}
