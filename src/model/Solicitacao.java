package model;

public class Solicitacao {
	private int id;
	private String status;
	private int codAlunoAprende;
	private String emailAprende;
	private int codAlunoEnsina;
	private String emailEnsina;
	private String assunto;
	private int codMateria;
	private int codAula;
	private String local;
	private String data;
	private String horaInicio;
	private String horaFinal;
	private String dataRealizacao; //data de realização da solicitação
	
	public Solicitacao() {}

	public Solicitacao(int id, String status, int codAlunoAprende, String emailAprende, int codAlunoEnsina,
			String emailEnsina, String assunto, int codMateria, int codAula, String local, String data,
			String horaInicio, String horaFinal, String dataRealizacao) {
		super();
		this.id = id;
		this.status = status;
		this.codAlunoAprende = codAlunoAprende;
		this.emailAprende = emailAprende;
		this.codAlunoEnsina = codAlunoEnsina;
		this.emailEnsina = emailEnsina;
		this.assunto = assunto;
		this.codMateria = codMateria;
		this.codAula = codAula;
		this.local = local;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.dataRealizacao = dataRealizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCodAlunoAprende() {
		return codAlunoAprende;
	}

	public void setCodAlunoAprende(int codAlunoAprende) {
		this.codAlunoAprende = codAlunoAprende;
	}

	public String getEmailAprende() {
		return emailAprende;
	}

	public void setEmailAprende(String emailAprende) {
		this.emailAprende = emailAprende;
	}

	public int getCodAlunoEnsina() {
		return codAlunoEnsina;
	}

	public void setCodAlunoEnsina(int codAlunoEnsina) {
		this.codAlunoEnsina = codAlunoEnsina;
	}

	public String getEmailEnsina() {
		return emailEnsina;
	}

	public void setEmailEnsina(String emailEnsina) {
		this.emailEnsina = emailEnsina;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public int getCodMateria() {
		return codMateria;
	}

	public void setCodMateria(int codMateria) {
		this.codMateria = codMateria;
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

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	@Override
	public String toString() {
		return "Solicitacao [id=" + id + ", status=" + status + ", codAlunoAprende=" + codAlunoAprende
				+ ", emailAprende=" + emailAprende + ", codAlunoEnsina=" + codAlunoEnsina + ", emailEnsina="
				+ emailEnsina + ", assunto=" + assunto + ", codMateria=" + codMateria + ", codAula=" + codAula
				+ ", local=" + local + ", data=" + data + ", horaInicio=" + horaInicio + ", horaFinal=" + horaFinal
				+ ", dataRealizacao=" + dataRealizacao + "]";
	}	
}
