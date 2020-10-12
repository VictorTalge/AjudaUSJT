package model;

import java.io.File;
import java.io.Serializable;

public class Noticia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int codAdm;
	private File foto;
	private boolean estado;
	private String descricao;
	private String titulo;
	private String texto;
	
	
	public Noticia() {}


	public Noticia(int id, int codAdm, File foto, boolean estado, String descricao, String titulo, String texto) {
		super();
		this.id = id;
		this.codAdm = codAdm;
		this.foto = foto;
		this.estado = estado;
		this.descricao = descricao;
		this.titulo = titulo;
		this.texto = texto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCodAdm() {
		return codAdm;
	}


	public void setCodAdm(int codAdm) {
		this.codAdm = codAdm;
	}


	public File getFoto() {
		return foto;
	}


	public void setFoto(File foto) {
		this.foto = foto;
	}


	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Noticia [id=" + id + ", codAdm=" + codAdm + ", foto=" + foto + ", estado=" + estado + ", descricao="
				+ descricao + ", titulo=" + titulo + ", texto=" + texto + "]";
	}
	
	
	
}
