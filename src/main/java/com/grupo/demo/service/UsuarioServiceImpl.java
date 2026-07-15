package com.grupo.demo.service;

import com.grupo.demo.model.Usuario;
import com.grupo.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("El usuario con: " + id + " no existe"));
    }

    @Override
    public Usuario getByUpn(String upn) {
        return usuarioRepository.findByUpn(upn).orElseThrow(()-> new RuntimeException("El usuario con: " + upn + " no existe"));
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario modificar(Integer id, Usuario usuarioActualizado){
        Usuario usuario = getById(id);
        usuario.setFullName(usuarioActualizado.getFullName());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setAdmin(usuarioActualizado.isAdmin());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
