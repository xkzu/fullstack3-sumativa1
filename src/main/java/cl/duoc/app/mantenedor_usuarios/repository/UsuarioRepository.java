package cl.duoc.app.mantenedor_usuarios.repository;

import cl.duoc.app.mantenedor_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
