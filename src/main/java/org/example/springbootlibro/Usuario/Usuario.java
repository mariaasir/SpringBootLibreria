package org.example.springbootlibro.Usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Lob
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "penalizacionHasta")
    private LocalDate penalizacionHasta;

    public Usuario(String dni, String nombre, String email, String password, String tipo, LocalDate penalizacionHasta) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.penalizacionHasta = penalizacionHasta;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @Size(max = 15) @NotNull String getDni() {
        return dni;
    }

    public void setDni(@Size(max = 15) @NotNull String dni) {
        this.dni = dni;
    }

    public @Size(max = 100) @NotNull String getNombre() {
        return nombre;
    }

    public void setNombre(@Size(max = 100) @NotNull String nombre) {
        this.nombre = nombre;
    }

    public @Size(max = 100) @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 100) @NotNull String email) {
        this.email = email;
    }

    public @Size(max = 255) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(max = 255) @NotNull String password) {
        this.password = password;
    }

    public @NotNull String getTipo() {
        return tipo;
    }

    public void setTipo(@NotNull String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getPenalizacionHasta() {
        return penalizacionHasta;
    }

    public void setPenalizacionHasta(LocalDate penalizacionHasta) {
        this.penalizacionHasta = penalizacionHasta;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                ", penalizacionHasta=" + penalizacionHasta +
                '}';
    }
}