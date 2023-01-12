package com.lojavirtual.service.impl;

import com.lojavirtual.model.entity.Usuario;
import com.lojavirtual.model.repository.UsuarioRepository;
import com.lojavirtual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario salvar(Usuario usuario, String confirmarSenha) {
        return repository.save(usuario);
    }

    @Override
    public Iterable<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario alterar(Usuario usuario, String confirmarSenha) {
        return null;
    }

    @Override
    public void apagar(Long id) {

    }
}
