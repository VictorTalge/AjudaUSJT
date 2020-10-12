package model;

import java.io.Serializable;

public class Aula implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codSolicitacao;
	private int codAula;
	private String local;
	private String data;
	private String hora;
	
	public Aula() {
		
	}


	public Aula(int codAula, String local, String data, String hora, int codSolicitacao) {
		super();
		this.codAula = codAula;
		this.local = local;
		this.data = data;
		this.hora = hora;
		this.codSolicitacao = codSolicitacao;
	}


	public int getCodAula() {
		return codAula;
	}


	public void setCodAula(int codAula) {
		this.codAula = codAula;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public int getCodSolicitacao() {
		return codSolicitacao;
	}


	public void setCodSolicitacao(int codSolicitacao) {
		this.codSolicitacao = codSolicitacao;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Aula [codAula=" + codAula + ", local=" + local + ", data=" + data + ", hora=" + hora
				+ ", codSolicitacao=" + codSolicitacao + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codAula;
		result = prime * result + codSolicitacao;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		if (codAula != other.codAula)
			return false;
		if (codSolicitacao != other.codSolicitacao)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}
	

}
