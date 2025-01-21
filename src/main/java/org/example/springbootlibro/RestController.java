package org.example.springbootlibro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    public RestController() {
    }

    @PostMapping({"/leerLibro"})
    public ResponseEntity<Libro> leerLibro(@RequestParam String isbn, @RequestParam String nombre, @RequestParam String autor) {
        Libro libro = new Libro(isbn, nombre, autor);
        return ResponseEntity.ok().body(libro);
    }

    @PostMapping({"/leerUsuario"})
    public ResponseEntity<Usuario> leerUsuario(@RequestParam String nickname, @RequestParam String password) {
        try {
            Usuario usuario = new Usuario(nickname, password);
            return ResponseEntity.ok().body(usuario);
        } catch (IllegalArgumentException var4) {
            return ResponseEntity.badRequest().build();
        }
    }
}
