package com.lojavirtual.service.impl;

import com.lojavirtual.exceptions.RegraNegocioException;
import com.lojavirtual.model.entity.Usuario;
import com.lojavirtual.model.repository.UsuarioRepository;
import com.lojavirtual.service.UsuarioService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario salvar(Usuario usuario, String confirmarSenha) {
        validar(usuario);
        if(!usuario.getSenha().equals(confirmarSenha)){
            throw new RegraNegocioException("As senhas são diferentes!");
        }
        return repository.save(usuario);
    }

    @Override
    public Iterable<Usuario> listar() {
        return repository.findAll();
    }

    @Override
    public Usuario alterar(Usuario usuario, String confirmarSenha) {
        return null;
    }

    @Override
    public void apagar(Long id) {

    }

    private void validar(Usuario usuario) {
        List<String> errors = obterPossiveisErrosValidacao(usuario);

        if (!errors.isEmpty()) {
            throw new RegraNegocioException(String.join("\r\n", errors));
        }
    }

    private List<String> obterPossiveisErrosValidacao(Usuario usuario) {
        List<String> errors = new ArrayList<>();

        if (isNotValid(usuario.getNome())) {
            errors.add("O nome do usuário está vazio");
        }

        if (isNotValid(usuario.getEmail())) {
            errors.add("O email do usuário está vazio");
        }

        if (repository.existsByEmail(usuario.getEmail())) {
            errors.add("Este email já foi cadastrado em nosso sistema!");
        }

        if (isNotValid(usuario.getSenha())) {
            errors.add("A senha do usuário é nula ou vazia!");
        }

        return errors;
    }

    private boolean isNotValid(String value) {
        return Objects.isNull(value) || Strings.isBlank(value);
    }
}
