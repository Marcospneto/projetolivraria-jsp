package br.com.jvm.projetolivraria.model.entidades;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private String perfil;

	public Usuario() {

	}

	public Usuario(Long id, String login, String senha, String perfil) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean sucessoAoLogar(String login, String senha) {
		return this.login.equalsIgnoreCase(login) && this.senha.equalsIgnoreCase(senha);
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}
