package service;

import java.util.ArrayList;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario){
		dao.excluir(usuario);
	}
	
	public Usuario carregar(String email){
		return dao.carregar(email);
	}
	public Usuario carregar(int id){
		return dao.carregar(id);
	}
	public ArrayList<Usuario> buscarUsuarios(int codMateriaBoa) {
		try {
			return dao.buscarAlunosMateria(codMateriaBoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
