package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

public class NoticiaDAO {

	public int criar(Noticia noticia) {
		String sqlInsert = "INSERT INTO noticia(descricao, titulo, texto, foto, estado, codAdm) VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			stm.setString(4, null);
			stm.setBoolean(5, noticia.getEstado());
			stm.setInt(6, noticia.getCodAdm());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					noticia.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticia.getId();
	}

	public void atualizar(Noticia noticia) {
		String sqlUpdate = "UPDATE noticia SET descricao=?, titulo=?, texto=?, estado =?, foto=?, codAdm =? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			stm.setBoolean(4, noticia.getEstado());
			stm.setString(5, null);
			stm.setInt(6, noticia.getCodAdm());
			stm.setInt(7, noticia.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM noticia WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Noticia carregar(int id) {
		Noticia noticia = new Noticia();
		noticia.setId(id);
		String sqlSelect = "SELECT descricao, titulo, texto, estado, codAdm FROM noticia WHERE noticia.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, noticia.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setDescricao(rs.getString("descricao"));
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setTexto(rs.getString("texto"));
					noticia.setFoto(null);
					noticia.setEstado(rs.getBoolean("estado"));
					noticia.setCodAdm(rs.getInt("codAdm"));
				} else {
					noticia.setId(-1);
					noticia.setDescricao(null);
					noticia.setTitulo(null);
					noticia.setTexto(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}
	


	public ArrayList<Noticia> buscarNoticias() throws Exception {
		ArrayList<Noticia> colecaoNoticias = new ArrayList<>();
		String select = "SELECT * FROM noticia order by id desc";
		
		Connection conectar = ConnectionFactory.obtemConexao();
		PreparedStatement pst = conectar.prepareStatement(select);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			Noticia noticia = new Noticia();
			noticia.setId(rs.getInt("id"));
			noticia.setDescricao(rs.getString("descricao"));
			noticia.setTitulo(rs.getString("titulo"));
			noticia.setTexto(rs.getString("texto"));
			noticia.setFoto(null);
			noticia.setEstado(rs.getBoolean("estado"));
			noticia.setCodAdm(rs.getInt("codAdm"));
			
			colecaoNoticias.add(noticia);
		}
			
			return colecaoNoticias;
		}

}
