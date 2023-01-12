package com.lojavirtual.service;


import com.lojavirtual.model.entity.Usuario;

public interface UsuarioService {

    public Usuario salvar(Usuario usuario, String confirmarSenha);

    public Iterable<Usuario> listar();

    public Usuario alterar(Usuario usuario, String confirmarSenha);

    public void apagar(Long id);


}
