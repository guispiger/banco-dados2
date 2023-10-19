package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

@Component
public class MysqlEnderecoDAO implements EnderecoDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BairroDAO bairroDAO;

	@Override
	public void inserir(Endereco endereco, Long idPaciente) {
		String sql = "insert into endereco (logradouro, numero, cep, BairroID, pacienteID) values (?, ?, ?, ?, ?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, endereco.getLogradouro());
			preparedStatement.setInt(2, endereco.getNumero());
			preparedStatement.setString(3, endereco.getCep());
			preparedStatement.setLong(4, endereco.getBairro().getId());
			preparedStatement.setLong(5, idPaciente);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Long idPaciente, Endereco end) {
		// TODO
	}

	@Override
	public void remover(Long idPaciente) {
		// TODO

	}

	@Override
	public List<Endereco> listarTodos() {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idEndereco, logradouro, numero, cep, bairroID from endereco");
			while (rs.next()) {
				Long id = rs.getLong(1);
				String logradouro = rs.getString(2);
				int numero = rs.getInt(3);
				String cep = rs.getString(4);
				Long bairroID = rs.getLong(5);

				Bairro bairro = bairroDAO.procurar(bairroID);

				enderecos.add(new Endereco(id, logradouro, numero, cep, bairro));
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enderecos;
	}

	@Override
	public Endereco procurar(Long idPaciente) {
		Endereco endereco = null;
		String sql = "select idEndereco, logradouro, numero, cep, bairroID from endereco where pacienteID = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, idPaciente);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong(1);
				String logradouro = rs.getString(2);
				int numero = rs.getInt(3);
				String cep = rs.getString(4);
				Long bairroID = rs.getLong(5);

				Bairro bairro = bairroDAO.procurar(bairroID);

				endereco = new Endereco(id, logradouro, numero, cep, bairro);

			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endereco;
	}

}
