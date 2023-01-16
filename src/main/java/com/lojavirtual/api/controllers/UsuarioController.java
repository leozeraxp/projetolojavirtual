package com.lojavirtual.api.controllers;

import com.lojavirtual.api.dto.UsuarioDto;
import com.lojavirtual.model.entity.Usuario;
import com.lojavirtual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario/")
public class UsuarioController {

    @Autowired
    private UsuarioService service;
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody UsuarioDto dto, String confirmarSenha){
        Usuario usuario = Usuario.builder().nome(dto.getNome()).email(dto.getEmail()).senha(dto.getSenha()).build();

        try {
            Usuario usuarioSalvo = service.salvar(usuario, confirmarSenha);
            return new ResponseEntity<Object>(usuarioSalvo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
