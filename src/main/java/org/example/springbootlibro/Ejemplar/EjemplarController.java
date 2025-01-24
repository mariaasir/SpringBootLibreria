package org.example.springbootlibro.Ejemplar;

import jakarta.validation.Valid;
import org.example.springbootlibro.Libro.Libro;
import org.example.springbootlibro.Prestamos.Prestamo;
import org.example.springbootlibro.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarController {
    EjemplaresRepository repositorioEjemplares;

    @Autowired
    public EjemplarController(EjemplaresRepository repositorioEjemplares) {
        this.repositorioEjemplares = repositorioEjemplares;
    }

    //GET --> SELECT *
    @GetMapping("/getEjemplares")
    public ResponseEntity<List<Ejemplar>> getEjemplares() {
        List<Ejemplar> lista = this.repositorioEjemplares.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET EJEMPLAR BY ID
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Ejemplar> getEjemplarJson(@PathVariable int id) {
        Ejemplar e = this.repositorioEjemplares.findById(String.valueOf(id)).get();
        return ResponseEntity.ok(e);
    }

    //POST de un Objeto Ejemplar
    @PostMapping("/ejemplar")
    public ResponseEntity<Ejemplar> addEjemplar(@Valid @RequestBody Ejemplar ejemplar) {
        System.out.println("Entra aqui");
        Ejemplar ejemplarPersistido = this.repositorioEjemplares.save(ejemplar);
        return ResponseEntity.ok().body(ejemplarPersistido);
    }

    //POST con Form Normal
    @PostMapping(value = "/ejemplarForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ejemplar> addEjemplarForm(
                                                    @RequestParam Libro isbn,
                                                    @RequestParam String estado

    ) {
        Ejemplar ejemplarNuevo = new Ejemplar();
        ejemplarNuevo.setIsbn(isbn);
        ejemplarNuevo.setEstado(estado);

        this.repositorioEjemplares.save(ejemplarNuevo);
        return ResponseEntity.created(null).body(ejemplarNuevo);
    }

    //PUT --> UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> updateEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar ejemplarPersistido = repositorioEjemplares.save(ejemplar);
        return ResponseEntity.ok().body(ejemplarPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEjemplar(@PathVariable int id) {
        repositorioEjemplares.deleteById(String.valueOf(id));
        String mensaje = "Ejemplar con id: " + id + " borrado";
        return ResponseEntity.ok().body(mensaje);
    }
}
