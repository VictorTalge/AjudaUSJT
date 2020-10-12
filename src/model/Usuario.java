package model;

import java.io.File;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String cidade;
	private String estado;
	private String ra;
	private String senha;
	private int codMateriaBoa;
	private String foto;
	private String adm;
	
	public Usuario() {}
	
	public Usuario(int id, String nome, String email, String cidade, String estado, String ra, String senha,
			int codMateriaBoa, String foto, String adm) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
		this.estado = estado;
		this.ra = ra;
		this.senha = senha;
		this.codMateriaBoa = codMateriaBoa;
		this.foto = foto;
		this.adm = adm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodMateriaBoa() {
		return codMateriaBoa;
	}

	public void setCodMateriaBoa(int codMateriaBoa) {
		this.codMateriaBoa = codMateriaBoa;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cidade=" + cidade + ", estado=" + estado
				+ ", ra=" + ra + ", senha=" + senha + ", codMateriaBoa=" + codMateriaBoa + ", foto=" + foto + ", adm="
				+ adm + "]";
	}
	

}