package br.com.jvm.projetolivraria.model.entidades;

public class Livro {

	private Long id;
	private String titulo;
	private String genero;
	private String quantidadePaginas;
	private String isbn;

	public Livro() {
		
	}
	
	public Livro(Long id, String titulo, String genero, String quantidadePaginas, String isbn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.quantidadePaginas = quantidadePaginas;
		this.isbn = isbn;
	}

	public Livro(String titulo, String genero) {
		super();
		this.titulo = titulo;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(String quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
	
