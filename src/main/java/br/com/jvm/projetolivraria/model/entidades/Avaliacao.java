package br.com.jvm.projetolivraria.model.entidades;

public class Avaliacao {

	private Long id;
	private Livro livro;
	private int nota;
	
	
	public Avaliacao() {
		
	}

	public Avaliacao(Long id, Livro livro, int nota) {
		super();
		this.id = id;
		this.livro = livro;
		this.nota = nota;
		;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
