package org.example.springbootlibro.Prestamos;

import jakarta.validation.Valid;
import org.example.springbootlibro.Ejemplar.Ejemplar;
import org.example.springbootlibro.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamosController {
    PrestamosRepository repositorioPrestamos;

    @Autowired
    public PrestamosController(PrestamosRepository repositorioPrestamos) {
        this.repositorioPrestamos = repositorioPrestamos;
    }

    //GET --> SELECT *
    @GetMapping("/getPrestamos")
    public ResponseEntity<List<Prestamo>> getPrestamos() {
        List<Prestamo> lista = this.repositorioPrestamos.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET PRESTAMO BY ID
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Prestamo> getPrestamoJson(@PathVariable String id) {
        Prestamo p = this.repositorioPrestamos.findById(id).get();
        return ResponseEntity.ok(p);
    }

    //POST de un Objeto Prestamo
    @PostMapping("/prestamo")
    public ResponseEntity<Prestamo> addPrestamo(@Valid @RequestBody Prestamo prestamo) {
        System.out.println("Entra aqui");
        Prestamo prestamoPersistido = this.repositorioPrestamos.save(prestamo);
        return ResponseEntity.ok().body(prestamoPersistido);
    }

    //POST con Form Normal
    @PostMapping(value = "/prestamoForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Prestamo> addPrestamoForm(
                                                    @RequestParam Usuario usuario,
                                                    @RequestParam Ejemplar ejemplar,
                                                    @RequestParam LocalDate fechaInicio,
                                                    @RequestParam LocalDate fechaDevolucion
    ) {
        Prestamo prestamo = new Prestamo();

        prestamo.setUsuario(usuario);
        prestamo.setEjemplar(ejemplar);
        prestamo.setFechaInicio(fechaInicio);
        prestamo.setFechaDevolucion(fechaDevolucion);
        this.repositorioPrestamos.save(prestamo);
        return ResponseEntity.created(null).body(prestamo);
    }

    //PUT --> UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@RequestBody Prestamo prestamo) {
        Prestamo prestamoPersistido = repositorioPrestamos.save(prestamo);
        return ResponseEntity.ok().body(prestamoPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrestamo(@PathVariable String id) {
        repositorioPrestamos.deleteById(id);
        String mensaje = "Prestamo con id: " + id + " borrado";
        return ResponseEntity.ok().body(mensaje);
    }
}
