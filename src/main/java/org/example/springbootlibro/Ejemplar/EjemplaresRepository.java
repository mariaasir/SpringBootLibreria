package org.example.springbootlibro.Ejemplar;

import org.example.springbootlibro.Prestamos.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplaresRepository extends JpaRepository<Ejemplar, String> {


}
