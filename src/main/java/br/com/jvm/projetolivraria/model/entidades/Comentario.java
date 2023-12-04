package br.com.jvm.projetolivraria.model.entidades;

import java.util.Date;

public class Comentario {
	public Long id;
	public Usuario usuario;
	public Livro livro;
	public String comentario;
	private Date data_comentario;
	
	 public Comentario() {
		 
	 }

	public Comentario(Long id, Usuario usuario, Livro livro, String comentario, Date data_comentario) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.livro = livro;
		this.comentario = comentario;
		this.data_comentario = data_comentario;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getData_comentario() {
		return data_comentario;
	}

	public void setData_comentario(Date data_comentario) {
		this.data_comentario = data_comentario;
	}

	@Override
	public String toString() {
		return "comentario=" + comentario;
	}

	
	
	 
}
