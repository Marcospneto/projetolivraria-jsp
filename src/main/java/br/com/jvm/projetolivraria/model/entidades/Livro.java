package br.com.jvm.projetolivraria.model.entidades;

import java.util.List;

public class Livro {

	private Long id;
	private String titulo;
	private String genero;
	private String quantidadePaginas;
	private String isbn;
	private String sinopse;
	private String autor;
	private List<Comentario> comentario;
	private Integer avaliacao;
	private String imagem;
	private String extensaoImg;

	public Livro() {

	}

	public Livro(Long id, String titulo, String genero, String quantidadePaginas, String isbn, String sinopse,
			String autor, List<Comentario> comentario, Integer avaliacao, String imagem, String extensaoImg) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.quantidadePaginas = quantidadePaginas;
		this.isbn = isbn;
		this.sinopse = sinopse;
		this.autor = autor;
		this.comentario = comentario;
		this.avaliacao = avaliacao;
		this.imagem = imagem;
		this.setExtensaoImg(extensaoImg);

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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Comentario> getComentarios() {
		return comentario;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentario = comentarios;
	}

	public Integer getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Integer avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@Override
	public String toString() {
	return "comentario=" + comentario;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getExtensaoImg() {
		return extensaoImg;
	}

	public void setExtensaoImg(String extensaoImg) {
		this.extensaoImg = extensaoImg;
	}

	

}
