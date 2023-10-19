package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Component
public class MysqlPacienteDAO implements PacienteDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EnderecoDAO enderecoDAO;

	@Override
	public Long inserir(Paciente p) {
		long idPaciente = 0;
		String sql = "insert into paciente (nome, sobrenome, dataNascimento, telefone) values (?, ?, ?, ?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, p.getNome());
			preparedStatement.setString(2, p.getSobrenome());
			preparedStatement.setDate(3, Date.valueOf(p.getDataNascimento()));
			preparedStatement.setString(4, p.getTelefone());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();

			while (rs.next()) {
				idPaciente = rs.getInt(1);
			}

			conn.close();
			preparedStatement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Long.valueOf(idPaciente);
	}

	@Override
	public void atualizar(Long id, Paciente p) {
		// TODO
	}

	@Override
	public void remover(Long id) {
		// TODO

	}

	@Override
	public List<Paciente> listarTodos() {
		ArrayList<Paciente> pacientes = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select idPaciente, nome, sobrenome, dataNascimento, telefone from paciente");
			while (rs.next()) {
				Long id = rs.getLong(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				LocalDate datanascimento = rs.getDate(4).toLocalDate();
				String telefone = rs.getString(5);

				Endereco endereco = enderecoDAO.procurar(id);

				pacientes.add(new Paciente(id, nome, sobrenome, datanascimento, telefone, endereco));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	@Override
	public Paciente procurar(Long id) {
		Paciente paciente = null;
		String sql = "select idPaciente, nome, sobrenome, dataNascimento, telefone from paciente where idPaciente = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Long idPaciente = rs.getLong(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				LocalDate datanascimento = rs.getDate(4).toLocalDate();
				String telefone = rs.getString(5);

				Endereco endereco = enderecoDAO.procurar(id);

				paciente = new Paciente(idPaciente, nome, sobrenome, datanascimento, telefone, endereco);
			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paciente;
	}

}
