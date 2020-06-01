package com.fatec.scel.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;

@Entity(name = "Livro")
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 4, max = 4, message="ISBN deve ter 4 caracteres")
	private String isbn;
	
	
	@NotNull
    @Size(min = 1, max = 50, message="Titulo deve ter entre 1 e 50 caracteres")
	private String titulo;
	
	@NotNull
    @Size(min = 1, max = 50, message="Autor deve ter entre 1 e 50 caracteres")
	private String autor;
	
	public Livro() {
	}
	public Livro( String i, String t, String a) {
		this.isbn = i;
		this.titulo = t;
		this.autor = a;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
}
