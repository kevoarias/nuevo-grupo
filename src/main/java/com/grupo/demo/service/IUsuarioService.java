package com.grupo.demo.service;

import com.grupo.demo.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> getAll();

    public Usuario getById(Integer id);

    public Usuario getByUpn(String upn);

    public Usuario crear(Usuario usuario);

    public Usuario modificar(Integer id, Usuario usuario);

    public void eliminar (Integer id);

}