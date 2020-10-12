package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import email.Email;
import model.Solicitacao;

public class SolicitacaoDAO {

	public int criar(Solicitacao solicitacao) {

		String sqlInsert = "INSERT INTO ajudaSJ.solicitacao(status, codAlunoAprende, emailAprende, codAlunoEnsina, emailEnsina, codMateria, assunto, data, horaInicio, horaFinal, local ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, solicitacao.getStatus().toLowerCase());
			stm.setInt(2, solicitacao.getCodAlunoAprende());
			stm.setString(3, solicitacao.getEmailAprende());
			stm.setInt(4, solicitacao.getCodAlunoEnsina());
			stm.setString(5, solicitacao.getEmailEnsina());
			stm.setInt(6, solicitacao.getCodMateria());
			stm.setString(7, solicitacao.getAssunto());
			stm.setString(8, solicitacao.getData());
			stm.setString(9, solicitacao.getHoraInicio());
			stm.setString(10, solicitacao.getHoraFinal());
			stm.setString(11, solicitacao.getLocal());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			Email.novaSolicitacaoEnsina(solicitacao.getEmailEnsina(), "", "");
			Email.confirmaSolicitacao(solicitacao.getEmailAprende(), "");
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					solicitacao.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return solicitacao.getId();
	}

	public void atualizar(Solicitacao solicitacao) {
		String sqlUpdate = "UPDATE solicitacao SET status=?, codAlunoAprende = ?, emailAprende = ?, codAlunoEnsina = ?, emailEnsina = ?, codMateria = ?, assunto =?, data =?, horaInicio =?, horaFinal =?, local =? WHERE codSolicitacao=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1, solicitacao.getStatus());
			stm.setInt(2, solicitacao.getCodAlunoAprende());
			stm.setString(3, solicitacao.getEmailAprende());
			stm.setInt(4, solicitacao.getCodAlunoEnsina());
			stm.setString(5, solicitacao.getEmailEnsina());
			stm.setInt(6, solicitacao.getCodMateria());
			stm.setString(7, solicitacao.getAssunto());
			stm.setString(8, solicitacao.getData());
			stm.setString(9, solicitacao.getHoraInicio());
			stm.setString(10, solicitacao.getHoraFinal());
			stm.setString(11, solicitacao.getLocal());
			stm.setInt(12, solicitacao.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM solicitacao WHERE codSolicitacao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Solicitacao carregar(int id) {
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setId(id);
		String sqlSelect = "SELECT status, assunto, codAlunoAprende, emailAprende, codAlunoEnsina, emailEnsina, codMateria, data, horaInicio, horaFinal, local FROM solicitacao WHERE solicitacao.codSolicitacao = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, solicitacao.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					solicitacao.setStatus(rs.getString("status"));
					solicitacao.setAssunto(rs.getString("assunto"));
					solicitacao.setCodAlunoAprende(rs.getInt("codAlunoAprende"));
					solicitacao.setEmailAprende(rs.getString("emailAprende"));
					solicitacao.setCodAlunoEnsina(rs.getInt("codAlunoEnsina"));
					solicitacao.setEmailEnsina(rs.getString("emailEnsina"));
					solicitacao.setCodMateria(rs.getInt("codMateria"));
					solicitacao.setData(rs.getString("data"));
					solicitacao.setHoraInicio(rs.getString("horaInicio"));
					solicitacao.setHoraFinal(rs.getString("horaFinal"));
					solicitacao.setLocal(rs.getString("local"));
				} else {
					solicitacao.setId(-1);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return solicitacao;
	}

	public ArrayList<Solicitacao> solicitacoesAlunoAprende(int codAlunoAprende) {
		Solicitacao solicitacao = new Solicitacao();
		ArrayList<Solicitacao> colecaoSolicitacoes = new ArrayList<>();
		solicitacao.setCodAlunoAprende(codAlunoAprende);
		String sqlSelect = "SELECT codSolicitacao, assunto, status, codAlunoEnsina, emailEnsina, codMateria, data, horaInicio, horaFinal, local FROM solicitacao WHERE solicitacao.codAlunoAprende = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, solicitacao.getCodAlunoAprende());
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Solicitacao s = new Solicitacao();
					s.setId(rs.getInt("codSolicitacao"));
					s.setAssunto(rs.getString("assunto"));
					s.setStatus(rs.getString("status").toLowerCase());
					s.setCodAlunoEnsina(rs.getInt("codAlunoEnsina"));
					s.setEmailEnsina(rs.getString("emailEnsina"));
					s.setCodMateria(rs.getInt("codMateria"));
					s.setData(rs.getString("data"));
					s.setHoraInicio(rs.getString("horaInicio"));
					s.setHoraFinal(rs.getString("horaFinal"));
					s.setLocal(rs.getString("local"));

					colecaoSolicitacoes.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}

		return colecaoSolicitacoes;
	}

	public ArrayList<Solicitacao> solicitacoesAlunoEnsina(int codAlunoEnsina) {
		Solicitacao solicitacao = new Solicitacao();
		ArrayList<Solicitacao> colecaoSolicitacoes = new ArrayList<>();
		solicitacao.setCodAlunoEnsina(codAlunoEnsina);
		String sqlSelect = "SELECT codSolicitacao, assunto, status, codAlunoAprende, emailAprende, codMateria, data, horaInicio, horaFinal, local FROM solicitacao WHERE solicitacao.codAlunoEnsina = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, solicitacao.getCodAlunoEnsina());
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Solicitacao s = new Solicitacao();
					s.setId(rs.getInt("codSolicitacao"));
					s.setAssunto(rs.getString("assunto"));
					s.setStatus(rs.getString("status"));
					s.setCodAlunoAprende(rs.getInt("codAlunoAprende"));
					s.setEmailEnsina(rs.getString("emailAprende"));
					s.setCodMateria(rs.getInt("codMateria"));
					s.setData(rs.getString("data"));
					s.setHoraInicio(rs.getString("horaInicio"));
					s.setHoraFinal(rs.getString("horaFinal"));
					s.setLocal(rs.getString("local"));

					colecaoSolicitacoes.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return colecaoSolicitacoes;
	}

	public ArrayList<Solicitacao> carregarData() {
		System.out.println("Entri no metodo");
		Solicitacao solicitacao = new Solicitacao();
		ArrayList<Solicitacao> dataSolicitacoes = new ArrayList<>();
		String sqlSelect = "SELECT data FROM solicitacao";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Solicitacao s = new Solicitacao();
					s.setData(rs.getString("data"));
					dataSolicitacoes.add(s);
					System.out.println(solicitacao.toString());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		System.out.println(dataSolicitacoes.size());

		return dataSolicitacoes;
	}

	public ArrayList<Solicitacao> carregarData(int id) {
		System.out.println("Entrei no metodo");
		Solicitacao solicitacao = new Solicitacao();
		solicitacao.setId(id);
		ArrayList<Solicitacao> dataSolicitacoes = new ArrayList<>();
		String sqlSelect = "SELECT data FROM solicitacao where solicitacao.codAlunoAprende = ? or solicitacao.codAlunoEnsina = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, solicitacao.getId());
			stm.setInt(2, solicitacao.getId());
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Solicitacao s = new Solicitacao();
					s.setData(rs.getString("data"));
					dataSolicitacoes.add(s);
					System.out.println(solicitacao.toString());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		System.out.println(dataSolicitacoes.size());
		// System.out.prinln(dataSolicitacoes.size());
		return dataSolicitacoes;
	}
}
