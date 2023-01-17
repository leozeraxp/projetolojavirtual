package com.lojavirtual.model.repository;

import com.lojavirtual.model.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public boolean existsByEmail(String email);
}
