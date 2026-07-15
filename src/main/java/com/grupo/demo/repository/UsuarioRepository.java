package com.grupo.demo.repository;

import com.grupo.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // SELECT * FROM usuariosv2 WHERE upn = ?
    Optional<Usuario> findByUpn(String upn);
}
