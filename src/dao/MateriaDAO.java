package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Materia;
import model.Usuario;

public class MateriaDAO {

	public int criar(Materia materia) {

		String sqlInsert = "INSERT INTO ajudaSJ.materia(nome) VALUE (?)";

		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, materia.getNome());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					materia.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return materia.getId();
	}

	public void atualizar(Materia materia) {
		String sqlUpdate = "UPDATE materia SET nome=? WHERE codMateria=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {

			stm.setString(1, materia.getNome());
			stm.setInt(2, materia.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(String nome) {
		String sqlDelete = "DELETE FROM materia WHERE nome = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, nome);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Materia carregar(String nome) {
		Materia materia = new Materia();
		materia.setNome(nome);
		String sqlSelect = "SELECT codMateria FROM materia WHERE materia.nome = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, materia.getNome());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					materia.setId(rs.getInt("codMateria"));
					;
				} else {
					materia.setId(-1);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return materia;
	}

	public Materia carregar(int id) {
		Materia materia = new Materia();
		materia.setId(id);
		String sqlSelect = "SELECT nome FROM materia WHERE materia.codMateria = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, materia.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {

					materia.setNome(rs.getString("nome"));
					;
				} else {
					materia.setId(-1);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return materia;
	}

	public ArrayList<Materia> buscarMateria() {

		ArrayList<Materia> colecaoMateria = new ArrayList<>();

		String sqlSelect = "SELECT nome, codMateria FROM materia";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Materia materia = new Materia();
					materia.setNome(rs.getString("nome"));
					materia.setId(rs.getInt("codMateria"));
					System.out.println("Materia adcionada a coleção: " + materia.toString());
					colecaoMateria.add(materia);
					for (int i = 0; colecaoMateria.size() > i; i++) {
						System.out.println(colecaoMateria.get(i).toString());
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return colecaoMateria;
	}

}
