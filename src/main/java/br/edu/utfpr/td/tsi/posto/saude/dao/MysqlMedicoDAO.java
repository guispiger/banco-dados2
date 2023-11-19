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
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public class MysqlMedicoDAO implements MedicoDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EspecialidadeDAO especialidadeDAO;

	@Override
	public void inserir(Medico medico) {
		String sql = "insert into medico (idMedico, nome, sobrenome, telefone, crm, cpf, EspecialidadeId) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, medico.getIdMedico());
			preparedStatement.setString(2, medico.getNome());
			preparedStatement.setString(3, medico.getSobrenome());
			preparedStatement.setString(4, medico.getTelefone());
			preparedStatement.setString(5, medico.getCrm());
			preparedStatement.setString(6, medico.getCpf());
			preparedStatement.setString(7, medico.getEspecialidade().getIdEspecialidade());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Long idEspecialidade, Medico medico) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Medico medico) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Medico> listarTodos() {
		ArrayList<Medico> medicos = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select idMedico, nome, sobrenome, telefone, crm, cpf, EspecialidadeId from medico");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String telefone = rs.getString(4);
				String crm = rs.getString(5);
				String cpf = rs.getString(6);
				String EspecialidadeId = rs.getString(7);

				Especialidade especialidade = especialidadeDAO.procurar(EspecialidadeId);

				medicos.add(new Medico(id, nome, sobrenome, telefone, crm, cpf, especialidade));

			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicos;
	}

	@Override
	public Medico procurar(String idMedico) {
		Medico medico = null;
		String sql = "select idMedico, nome, sobrenome, telefone, crm, cpf, EspecialidadeId from medico where idMedico = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, idMedico);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String telefone = rs.getString(4);
				String crm = rs.getString(5);
				String cpf = rs.getString(6);
				String EspecialidadeId = rs.getString(7);

				Especialidade especialidade = especialidadeDAO.procurar(EspecialidadeId);

				medico = new Medico(id, nome, sobrenome, telefone, crm, cpf, especialidade);

			}
			rs.close();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return medico;
	}

}
