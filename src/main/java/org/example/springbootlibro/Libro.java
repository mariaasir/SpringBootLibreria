package org.example.springbootlibro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Size(max = 200)
    @NotNull
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Size(max = 100)
    @NotNull
    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libro() {
    }

    public @Size(max = 20) String getIsbn() {
        return isbn;
    }

    public void setIsbn(@Size(max = 20) String isbn) {
        this.isbn = isbn;
    }

    public @Size(max = 200) @NotNull String getTitulo() {
        return titulo;
    }

    public void setTitulo(@Size(max = 200) @NotNull String titulo) {
        this.titulo = titulo;
    }

    public @Size(max = 100) @NotNull String getAutor() {
        return autor;
    }

    public void setAutor(@Size(max = 100) @NotNull String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}