package org.example.springbootlibro.Libro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    @NotBlank(message = "El  campo ISBN no puede estar vacío")
    @Pattern(regexp = "^\\d{3}-\\d{1}-\\d{3}-\\d{5}-\\d{1}$", message = "Formato correcto:  000-0-000-00000-0")
    private String isbn;

    @Size(max = 200, message = "La longitud máxima del título debe ser de 200 caracteres")
    @NotNull(message = "No puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,200}$", message = "Solo admite caracteres alfanuméricos y espacios")
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 100, message = "La longitud máxima del autor debe ser de 100 caracteres")
    @NotNull(message = "No puede estar vacío")
    @Pattern(regexp = "^[A-Za-z0-9 ]{1,200}$", message = "Solo admite caracteres alfanuméricos y espacios")
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

}