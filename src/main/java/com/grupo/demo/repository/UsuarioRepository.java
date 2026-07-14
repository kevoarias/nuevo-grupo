package com.kevin.portalincidencias.repository;

import com.kevin.portalincidencias.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // SELECT * FROM usuariosv2 WHERE upn = ?
    Optional<Usuario> findByUpn(String upn);
}
