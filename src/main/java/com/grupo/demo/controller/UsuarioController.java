package com.grupo.demo.controller;

import com.grupo.demo.model.Usuario;
import com.grupo.demo.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Obtener todos los usuarios
    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    // Obtener usuario por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    // Obtener usuario por UPN
    @GetMapping("/buscar/{upn}")
    public ResponseEntity<Usuario> getByUpn(@PathVariable String upn) {
        return ResponseEntity.ok(usuarioService.getByUpn(upn));
    }

    // Crear usuario
    @PostMapping("nuevo-usuario)")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crear(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // Modificar usuario
    @PutMapping("/modificar/{id}")
    public ResponseEntity<Usuario> modificar(
            @PathVariable Integer id,
            @RequestBody Usuario usuario) {

        Usuario usuarioModificado = usuarioService.modificar(id, usuario);
        return ResponseEntity.ok(usuarioModificado);
    }

    // Eliminar usuario
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}