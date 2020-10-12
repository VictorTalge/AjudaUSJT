package service;

import model.Aula;
import dao.AulaDAO;


public class AulaService {
	AulaDAO dao = new AulaDAO();
	
	public int criar(Aula aula) {
		return dao.criar(aula);
	}
	
	public void atualizar(Aula aula){
		dao.atualizar(aula);
	}
	
	public void excluir(int codAula){
		dao.excluir(codAula);
	}
	
	public Aula carregar(int codAula){
		return dao.carregar(codAula);
	}

}
