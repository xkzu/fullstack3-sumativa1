package cl.duoc.app.mantenedor_usuarios.controller;

import cl.duoc.app.mantenedor_usuarios.model.Usuario;
import cl.duoc.app.mantenedor_usuarios.service.UsuarioService;
import cl.duoc.app.mantenedor_usuarios.util.UsuarioUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar() {
        try {
            return ResponseEntity.ok(usuarioService.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Usuario>> buscar(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        try {
            if (UsuarioUtil.isEmptyOrNull(usuario.getNombre())
                    || UsuarioUtil.isEmptyOrNull(usuario.getEmail())
                    || UsuarioUtil.isEmptyOrNull(usuario.getPassword())) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(usuarioService.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            usuario.setId(id);
            return ResponseEntity.ok(usuarioService.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            usuarioService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
