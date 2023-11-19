package br.edu.utfpr.td.tsi.posto.saude.dao;

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

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Component
public class MysqlEnderecoDAO implements EnderecoDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private BairroDAO bairroDAO;
	
	@Autowired
	private PacienteDAO pacienteDAO;

	@Override
	public void inserir(Endereco endereco, String idPaciente) {
		String id = UUID.randomUUID().toString();
		endereco.setId(id);
		String sql = "insert into endereco (idEndereco, logradouro, numero, cep, BairroID, pacienteID) values (?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			
			preparedStatement.setString(1, endereco.getId());
			preparedStatement.setString(2, endereco.getLogradouro());
			preparedStatement.setInt(3, endereco.getNumero());
			preparedStatement.setString(4, endereco.getCep());
			preparedStatement.setString(5, endereco.getBairro().getId());
			preparedStatement.setString(6, idPaciente);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(String idPaciente, Endereco end) {
		// TODO
	}

	@Override
	public void remover(String idPaciente) {
		// TODO

	}

	@Override
	public List<Endereco> listarTodos() {
		ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idEndereco, logradouro, numero, cep, bairroID, pacienteID from endereco");
			while (rs.next()) {
				String id = rs.getString(1);
				String logradouro = rs.getString(2);
				int numero = rs.getInt(3);
				String cep = rs.getString(4);
				String bairroID = rs.getString(5);
				String pacienteID = rs.getString(6);

				Bairro bairro = bairroDAO.procurar(bairroID);
				
				Paciente paciente = pacienteDAO.procurar(pacienteID);

				enderecos.add(new Endereco(id, logradouro, numero, cep, bairro, paciente));
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
	public Endereco procurarPorPacienteId(String idPaciente) {
		Endereco endereco = null;
		String sql = "select idEndereco, logradouro, numero, cep, bairroID from endereco where pacienteID = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, idPaciente);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String logradouro = rs.getString(2);
				int numero = rs.getInt(3);
				String cep = rs.getString(4);
				String bairroID = rs.getString(5);

				Bairro bairro = bairroDAO.procurar(bairroID);
				
			    Paciente paciente = pacienteDAO.procurar(idPaciente);

				endereco = new Endereco(id, logradouro, numero, cep, bairro, paciente);

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
