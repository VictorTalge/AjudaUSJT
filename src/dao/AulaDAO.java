package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aula;

public class AulaDAO {
	public int criar(Aula aula) {
		String sqlInsert = "INSERT INTO aula(local, data, hora, codSolicitacao) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, aula.getLocal());
			stm.setString(2, aula.getData());
			stm.setString(3, aula.getHora());
			stm.setInt(4, aula.getCodSolicitacao());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					aula.setCodSolicitacao(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aula.getCodAula();
	}

	public void atualizar(Aula aula) {
		String sqlUpdate = "UPDATE aula SET local=?, data=?, hora=?, codSolicitacao=? WHERE codAula=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, aula.getLocal());
			stm.setString(2, aula.getData());
			stm.setString(3, aula.getHora());
			stm.setInt(4, aula.getCodSolicitacao());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int codAula) {
		String sqlDelete = "DELETE FROM aula WHERE codAula = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, codAula);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Aula carregar(int codAula) {
		Aula aula = new Aula();
		aula.setCodAula(codAula);
		String sqlSelect = "SELECT local, data, hora, codSolicitacao FROM aula WHERE aula.codAula = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, aula.getCodAula());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aula.setLocal(rs.getString("local"));
					aula.setData(rs.getString("data"));
					aula.setHora(rs.getString("hora"));
					aula.setCodSolicitacao(rs.getInt("codSolicitacao"));
				} else {
					aula.setCodAula(-1);
					aula.setLocal(null);
					aula.setData(null);
					aula.setHora(null);
					aula.setCodSolicitacao(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aula;
	}

	public ArrayList<Aula> listarAula(int codAula) throws Exception {
		ArrayList<Aula> colecaoAula = new ArrayList<>();
		String select = "SELECT * FROM aula WHERE codAula =" + codAula + " order by codAula desc";

		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet resultado = pst.executeQuery();

		while (resultado.next()) {
			Aula aula = new Aula();
			// NoticiaService noticia = new NoticiaService();
			aula.setCodAula(resultado.getInt("codAula"));
			aula.setLocal(resultado.getString("local"));
			aula.setData(resultado.getString("data"));
			aula.setHora(resultado.getString(resultado.getInt("hora")));
			aula.setCodSolicitacao(resultado.getInt("codSolicitacao"));

			colecaoAula.add(aula);
		}
		return colecaoAula;
	}

}
