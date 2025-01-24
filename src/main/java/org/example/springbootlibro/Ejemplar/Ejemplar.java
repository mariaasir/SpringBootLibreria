package org.example.springbootlibro.Ejemplar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.example.springbootlibro.Libro.Libro;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "ejemplar")
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "isbn", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Libro isbn;



    @ColumnDefault("'Disponible'")
    @Lob
    @Column(name = "estado")
    private String estado;

    public Ejemplar(Integer id, Libro isbn, String estado) {
        this.id = id;
        this.isbn = isbn;
        this.estado = estado;
    }

    public Ejemplar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull Libro getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull Libro isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", estado='" + estado + '\'' +
                '}';
    }
}