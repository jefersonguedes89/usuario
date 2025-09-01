package com.javanauta.usuario.infrastructure.repository;

import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail (String email);

    boolean existsByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
