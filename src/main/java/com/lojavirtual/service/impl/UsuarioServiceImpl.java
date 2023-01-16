package com.lojavirtual.service.impl;

import com.lojavirtual.exceptions.RegraNegocioException;
import com.lojavirtual.model.entity.Usuario;
import com.lojavirtual.model.repository.UsuarioRepository;
import com.lojavirtual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario salvar(Usuario usuario, String confirmarSenha) {
        if(!usuario.getSenha().equals(confirmarSenha)){
            throw new RegraNegocioException("As senhas são diferentes!");
        }
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

    public void validar(Usuario usuario){
        String msg = "";
        if(Objects.isNull(usuario.getNome()) || usuario.getNome().isEmpty()){
            msg += "O usuário está com o nome vazio \r\n";
        }
    }
}
