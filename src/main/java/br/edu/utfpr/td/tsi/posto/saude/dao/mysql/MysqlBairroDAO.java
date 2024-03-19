package br.edu.utfpr.td.tsi.posto.saude.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Component
public class MysqlBairroDAO implements BairroDAO {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void inserir(Bairro bairro) {
		String id = UUID.randomUUID().toString();
		bairro.setId(id);
		String sql = "insert into bairro (idBairro, nome) values (?,?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, bairro.getId());
			preparedStatement.setString(2, bairro.getNome());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Bairro bairro) {
		String sql = "update bairro set nome = ? where idBairro = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, bairro.getNome());
			preparedStatement.setString(2, bairro.getId());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Bairro bairro) {
		String sql = "delete from bairro  where idBairro = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, bairro.getId());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Bairro> listarTodos() {
		ArrayList<Bairro> bairros = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idBairro, nome from bairro");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				bairros.add(new Bairro(id, nome));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bairros;
	}

	@Override
	public Bairro procurar(String id) {
		Bairro bairro = new Bairro();
		String sql = "select idBairro, nome from bairro where idBairro=?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String idBairro = rs.getString(1);
				String nome = rs.getString(2);
				
				bairro.setId(idBairro);
				bairro.setNome(nome);
			}
			conn.close();
			rs.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bairro;
	}

}

