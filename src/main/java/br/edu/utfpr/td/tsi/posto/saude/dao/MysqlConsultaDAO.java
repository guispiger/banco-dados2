package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public class MysqlConsultaDAO implements ConsultaDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	@Override
	public void inserir(Consulta consulta, Long idPaciente, Long idMedico) {
		String sql = "insert into consulta (dataHora, situacao, pacienteID, medicoID) values (?, ?, ?, ?)";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setTimestamp(1, Timestamp.valueOf(consulta.getDataHora()));
			preparedStatement.setString(2, consulta.getSituacao());
			preparedStatement.setLong(3, idPaciente);
			preparedStatement.setLong(4, idMedico);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void atualizar(Consulta consulta, Long idPaciente, Long idMedico) {
		String sql = "update consulta set dataHora = ?, situacao = ?, pacienteID = ?, medicoID = ? where idConsulta = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setTimestamp(1, Timestamp.valueOf(consulta.getDataHora()));
			preparedStatement.setString(2, consulta.getSituacao());
			preparedStatement.setLong(3, idPaciente);
			preparedStatement.setLong(4, idMedico);
			preparedStatement.setLong(5, consulta.getIdConsulta());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Long id) {
		String sql = "delete from consulta where idConsulta = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Consulta> listarTodos() {
		ArrayList<Consulta> consultas = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select idConsulta, dataHora, situacao, pacienteID, medicoID from consulta");
			while (rs.next()) {
				Long id = rs.getLong(1);
				LocalDateTime dataHora = LocalDateTime.parse(rs.getTimestamp(2).toString(),
						DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.n"));
				String situacao = rs.getString(3);
				Long pacienteID = rs.getLong(4);
				Long medicoID = rs.getLong(5);

				Paciente paciente = pacienteDAO.procurar(pacienteID);

				Medico medico = medicoDAO.procurar(medicoID);

				consultas.add(new Consulta(id, dataHora, situacao, paciente, medico));
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultas;
	}

	@Override
	public Consulta procurar(Long id) {
		Consulta consulta = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"select idConsulta, dataHora, situacao, pacienteID, medicoID from consulta where idConsulta = ?");
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long idConsulta = rs.getLong(1);
				LocalDateTime dataHora = LocalDateTime.parse(rs.getTimestamp(2).toString(),
						DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.n"));
				String situacao = rs.getString(3);
				Long pacienteID = rs.getLong(4);
				Long medicoID = rs.getLong(5);

				Paciente paciente = pacienteDAO.procurar(pacienteID);

				Medico medico = medicoDAO.procurar(medicoID);

				consulta = new Consulta(idConsulta, dataHora, situacao, paciente, medico);
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consulta;
	}

	@Override
	public List<Consulta> procurarPorPaciente(Long idPaciente) {
		ArrayList<Consulta> consultas = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"select idConsulta, dataHora, situacao, pacienteID, medicoID from consulta where pacienteID = ?");
			ps.setLong(1, idPaciente);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong(1);
				LocalDateTime dataHora = LocalDateTime.parse(rs.getTimestamp(2).toString(),
						DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss.n"));
				String situacao = rs.getString(3);
				Long pacienteID = rs.getLong(4);
				Long medicoID = rs.getLong(5);

				Paciente paciente = pacienteDAO.procurar(pacienteID);

				Medico medico = medicoDAO.procurar(medicoID);

				consultas.add(new Consulta(id, dataHora, situacao, paciente, medico));
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultas;
	}

}