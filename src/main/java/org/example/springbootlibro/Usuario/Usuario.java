package org.example.springbootlibro.Usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull(message = "El campo DNI no puede ser nulo")
    @Pattern(regexp = "(\\d{8})([A-Z]{1})" , message = "El campo DNI tiene que tener este formato: 00000000X ")
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Size(max = 100)
    @NotNull(message = "El campo nombre no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9]{1,200}$", message = "Solo admite caracteres alfanuméricos y espacios")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "El campo email no puede ser nulo")
    @Pattern(regexp = "[A-Za-z0-9]{1,50}@[A-Za-z]{1,30}.[A-Za-z]{1,4}", message = "El email debe tener este formato: xxxxx@xxx.xxx ")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull(message = "El campo password no puede ser nulo")
    @Pattern(regexp = "^[A-Za-z0-9]{4,12}$" , message = "La contraseña debe tener entre 4 y 12 caracteres alfanuméricos")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "El campo tipo no puede ser nulo")
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(Normal|Administrador)$", message = "El tipo debe ser uno de los siguientes valores: normal, administrador")
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;


}