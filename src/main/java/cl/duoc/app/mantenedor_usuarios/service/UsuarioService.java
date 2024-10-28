package cl.duoc.app.mantenedor_usuarios.service;

import cl.duoc.app.mantenedor_usuarios.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

}
