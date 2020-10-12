package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;
import email.Email;
public class UsuarioDAO {
	public int criar(Usuario usuario) {
		System.out.print(usuario.toString());
		String sqlInsert = "INSERT INTO ajudaSJ.usuario(nome, email, cidade, estado, ra, senha, codMateriaBoa, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCidade());
			stm.setString(4, usuario.getEstado());
			stm.setString(5, usuario.getRa());
			System.out.print(usuario.getSenha());
			stm.setString(6, usuario.getSenha());
			stm.setInt(7, usuario.getCodMateriaBoa());
			stm.setString(8, "icone-usuario.png");
			
			
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			Email.emailBoasVindas(usuario);
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario.getId();
	}

	public void atualizar(Usuario usuario) {
		
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, cidade=?, estado=?, ra=?, senha=?, codMateriaBoa=?, foto=?, adm=? WHERE codUsuario=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			System.out.println("Usuario vai ser atualizado para:  " +usuario.toString());
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getCidade());
			stm.setString(4, usuario.getEstado());
			stm.setString(5, usuario.getRa());
			stm.setString(6, usuario.getSenha());
			stm.setInt(7, usuario.getCodMateriaBoa());
			stm.setString(8, usuario.getFoto());
			stm.setString(9, usuario.getAdm());
			stm.setInt(10, usuario.getId());
			stm.execute();
			//Email.alteracaoDados(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}

	public void excluir(Usuario usuario) {
		String sqlDelete = "DELETE FROM usuario WHERE usuario.email = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, usuario.getEmail());
			stm.execute();
			Email.avisoExclusao(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(String email) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		String sqlSelect = "SELECT nome, codUsuario, senha, cidade, estado, ra, codMateriaBoa, foto, adm FROM usuario WHERE usuario.email = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getEmail());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					usuario.setNome(rs.getString("nome"));
					usuario.setId(rs.getInt("codUsuario"));
					usuario.setCidade(rs.getString("cidade"));
					usuario.setEstado(rs.getString("estado"));
					usuario.setRa(rs.getString("ra"));
					usuario.setCodMateriaBoa(rs.getInt("codMateriaBoa"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setFoto(rs.getString("foto"));	
					usuario.setAdm(rs.getString("adm"));	
					
				} else {
					
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setCidade(null);
					usuario.setEstado(null);
					usuario.setRa(null);
					usuario.setCodMateriaBoa(-1);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public Usuario carregar(int id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		String sqlSelect = "SELECT nome, email, senha, cidade, estado, ra, codMateriaBoa, foto, adm FROM usuario WHERE usuario.codUsuario= ?";
	
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuario.setCidade(rs.getString("cidade"));
					usuario.setEstado(rs.getString("estado"));
					usuario.setRa(rs.getString("ra"));
					usuario.setCodMateriaBoa(rs.getInt("codMateriaBoa"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setFoto(rs.getString("foto"));
					usuario.setAdm(rs.getString("adm"));
					
				} else {
					
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setEmail(null);
					usuario.setCidade(null);
					usuario.setEstado(null);
					usuario.setRa(null);
					usuario.setCodMateriaBoa(-1);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}


	public ArrayList<Usuario>  buscarAlunosMateria(int codMateriaBoa) {
		Usuario usuario = new Usuario();
		ArrayList<Usuario> colecaoUsuario = new ArrayList<>();
		usuario.setCodMateriaBoa(codMateriaBoa);
		String sqlSelect = "SELECT nome, codUsuario, senha, cidade, estado, ra, codMateriaBoa, foto FROM usuario WHERE usuario.codMateriaBoa = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuario.getCodMateriaBoa());
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Usuario u = new Usuario();
					u.setNome(rs.getString("nome"));
					u.setId(rs.getInt("codUsuario"));
					u.setCidade(rs.getString("cidade"));
					u.setEstado(rs.getString("estado"));
					u.setRa(rs.getString("ra"));
					u.setCodMateriaBoa(rs.getInt("codMateriaBoa"));
					u.setSenha(rs.getString("senha"));
					u.setFoto(rs.getString("foto"));
					System.out.println("Buscando Professores: " + u.toString());
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
