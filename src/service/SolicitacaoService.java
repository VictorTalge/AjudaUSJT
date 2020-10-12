package service;

import java.util.ArrayList;

import dao.SolicitacaoDAO;
import model.Materia;
import model.Solicitacao;

public class SolicitacaoService {

	SolicitacaoDAO dao = new SolicitacaoDAO();

	public int criar(Solicitacao solicitacao) {
		return dao.criar(solicitacao);
	}

	public void atualizar(Solicitacao solicitacao) {
		dao.atualizar(solicitacao);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Solicitacao carregar(int id) {
		return dao.carregar(id);
	}

	public ArrayList<Solicitacao> solicitacoesAlunoAprende(int codAlunoAprende) {
		try {
			return dao.solicitacoesAlunoAprende(codAlunoAprende);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<Solicitacao> solicitacoesAlunoEnsina(int  codAlunoEnsina) {
		try {
			return dao.solicitacoesAlunoEnsina(codAlunoEnsina);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Solicitacao> carregarData() {
		System.out.println("Entrei no service");
		try {
			return dao.carregarData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<Solicitacao> carregarData(int id) {
        System.out.println("Entrei no service");
        try {
            return dao.carregarData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
	
}
