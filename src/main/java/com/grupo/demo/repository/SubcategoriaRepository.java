package com.kevin.portalincidencias.repository;

import com.kevin.portalincidencias.model.Subcategoria;
import com.kevin.portalincidencias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer>{

    List <Subcategoria> findByCategoria (Categoria categoria);
    Optional <Subcategoria> findByNombre (String nombre);
}
