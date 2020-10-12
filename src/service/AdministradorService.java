package service;

import java.util.ArrayList;

import dao.AdministradorDAO;
import model.Administrador;
import model.Usuario;

public class AdministradorService {
	
	AdministradorDAO dao = new AdministradorDAO();
	
	public int criar(Administrador admnistrador) {
		return dao.criar(admnistrador);
	}
	
	public void atualizar(Administrador admnistrador){
		dao.atualizar(admnistrador);
	}
	
	public void excluir(Administrador admnistrador){
		dao.excluir(admnistrador);
	}
	
	public Administrador carregar(String email){
		return dao.carregar(email);
	}
	public ArrayList<Usuario> buscarUsuarios() {
		try {
			return dao.buscarAlunos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
