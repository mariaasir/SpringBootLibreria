package org.example.springbootlibro.Usuario;

import jakarta.validation.Valid;
import org.example.springbootlibro.Libro.Libro;
import org.example.springbootlibro.Usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    UsuariosRepository repositorioUsuarios;

    @Autowired
    public UsuarioController(UsuariosRepository repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    //GET --> SELECT *
    @GetMapping("/getUsuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> lista = this.repositorioUsuarios.findAll();
        System.out.println(lista);
        return ResponseEntity.ok(lista);
    }

    //GET USUARIO BY ID
    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Usuario> getUsuarioJson(@PathVariable String id) {
        Usuario u = this.repositorioUsuarios.findById(id).get();
        return ResponseEntity.ok(u);
    }

    //POST de un Objeto Usuario
    @PostMapping("/usuario")
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario usuarioPersistido = this.repositorioUsuarios.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //POST con Form Normal
    @PostMapping(value = "/usuarioForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Usuario> addUsuarioForm(
                                                        @RequestParam String dni,
                                                        @RequestParam String nombre,
                                                        @RequestParam String email,
                                                        @RequestParam String password,
                                                        @RequestParam String tipo,
                                                        @RequestParam LocalDate penalizacionHasta
    ) {
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setTipo(tipo);
        usuario.setPenalizacionHasta(penalizacionHasta);
        this.repositorioUsuarios.save(usuario);
        return ResponseEntity.created(null).body(usuario);
    }

    //PUT --> UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        //Verificar si el usuario existe
        if (!repositorioUsuarios.existsById(String.valueOf(id))) {
            return ResponseEntity.notFound().build();
        }

        //Asegurarse de que el id recibido coincide con el id del usuario
        usuario.setId(id);

        //Guardar el usuario actualizado
        Usuario usuarioPersistido = repositorioUsuarios.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
        repositorioUsuarios.deleteById(id);
        String mensaje = "Usuario con id: " + id + " borrado";
        return ResponseEntity.ok().body(mensaje);
    }
}
