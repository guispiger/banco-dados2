package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

public class MysqlEspecialidadeDAO implements EspecialidadeDAO {

	@Autowired
	private DataSource dataSource;

	@Override
	public void inserir(Especialidade especialidade) {
		String sql = "insert into especialidade (descricao) values (?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, especialidade.getDescricao());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Especialidade especialidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Especialidade especialidade) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Especialidade> listarTodos() {
		ArrayList<Especialidade> especialidades = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idEspecialidade, descricao from especialidade");
			while (rs.next()) {
				Long id = rs.getLong(1);
				String descricao = rs.getString(2);
				especialidades.add(new Especialidade(id, descricao));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especialidades;
	}

	@Override
	public Especialidade procurar(Long idEspecialidade) {
		Especialidade especialidade = null;
		String sql = "select idEspecialidade, descricao from especialidade where idEspecialidade = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, idEspecialidade);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong(1);
				String descricao = rs.getString(2);

				especialidade = new Especialidade(id, descricao);

			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especialidade;
	}

}
