package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import email.Email;
import model.Administrador;
import model.Usuario;

public class AdministradorDAO {

	public int criar(Administrador administrador) {
		String sqlInsert = "INSERT INTO ajudaSJ.administrador(nome, email, senha) VALUES (?, ?, ?)";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, administrador.getNome());
			stm.setString(2, administrador.getEmail());
			stm.setString(3, administrador.getSenha());
			Email.emailBoasVindas(administrador);
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					administrador.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return administrador.getId();
	}

	public void atualizar(Administrador administrador) {
		String sqlUpdate = "UPDATE administrador SET nome=?, senha=? WHERE email=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1, administrador.getNome());
			stm.setString(3, administrador.getEmail());
			stm.setString(2, administrador.getSenha());
			
			stm.execute();
			Email.alteracaoDados(administrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Administrador administrador) {
		String sqlDelete = "DELETE FROM administrador WHERE administrador.email = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, administrador.getEmail());
			Email.avisoExclusao(administrador);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Administrador carregar(String email) {
		Administrador administrador = new Administrador();
		administrador.setEmail(email);
		String sqlSelect = "SELECT nome, senha FROM administrador WHERE administrador.email = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, administrador.getEmail());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					administrador.setNome(rs.getString("nome"));
					//administrador.setEmail(rs.getString("email"));
					administrador.setSenha(rs.getString("senha"));
				
				} else {
					administrador.setId(-1);
					administrador.setNome(null);
					administrador.setEmail(null);
					administrador.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return administrador;
	}

	
	
	public ArrayList<Usuario>  buscarAlunos() {
		Usuario usuario = new Usuario();
		ArrayList<Usuario> colecaoUsuario = new ArrayList<>();
		
		String sqlSelect = "SELECT * FROM usuario";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Usuario u = new Usuario();								
				
					u.setId(rs.getInt("codUsuario"));
					u.setNome(rs.getString("nome"));
					u.setNome(rs.getString("nome"));
					u.setEmail(rs.getString("email"));
					u.setCidade(rs.getString("cidade"));
					u.setEstado(rs.getString("estado"));
					u.setRa(rs.getString("ra"));
					u.setCodMateriaBoa(rs.getInt("codMateriaBoa"));
					u.setSenha(rs.getString("senha"));
					u.setFoto(rs.getString("foto"));
					u.setAdm(rs.getString("adm"));
;
					colecaoUsuario.add(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return colecaoUsuario;
	}

}
