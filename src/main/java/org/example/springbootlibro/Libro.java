package org.example.springbootlibro;


public class Libro {
	private String isbn;
	private String nombre;
	private String autor;

	public Libro(String isbn, String nombre, String autor) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String toString() {
		return "Libro{isbn='" + this.isbn + "', nombre='" + this.nombre + "', autor='" + this.autor + "'}";
	}
}
