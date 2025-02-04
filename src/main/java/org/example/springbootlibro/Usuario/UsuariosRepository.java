package org.example.springbootlibro.Usuario;

import org.example.springbootlibro.Libro.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, String> {


}
