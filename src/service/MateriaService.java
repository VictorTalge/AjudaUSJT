package service;

import java.util.ArrayList;

import dao.MateriaDAO;
import model.Materia;

public class MateriaService {

	MateriaDAO dao = new MateriaDAO();

	public int criar(Materia materia) {
		return dao.criar(materia);
	}

	public void atualizar(Materia materia) {
		dao.atualizar(materia);
	}

	public void excluir(String nome) {
		dao.excluir(nome);
	}

	public Materia carregar(String nome) {
		return dao.carregar(nome);
	}
	public Materia carregar(int id) {
		return dao.carregar(id);
	}


	public ArrayList<Materia> buscarMateria() {
		try {
			return dao.buscarMateria();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
