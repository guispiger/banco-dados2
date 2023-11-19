package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "consulta", schema = "posto_saude")
public class Consulta {
	@Id
	@Column(name = "idConsulta", nullable = false, unique = true)
	private String idConsulta;

	@Column(name = "dataHora", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataHora;

	@Column(name = "situacao", length = 45, nullable = false)
	private String situacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pacienteID", referencedColumnName = "idPaciente")
	private Paciente paciente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medicoID", referencedColumnName = "idMedico")
	private Medico medico;

	public Consulta() {
	}

	public Consulta(String idConsulta, LocalDateTime dataHora, String situacao, Paciente paciente, Medico medico) {
		super();
		this.idConsulta = idConsulta;
		this.dataHora = dataHora;
		this.situacao = situacao;
		this.paciente = paciente;
		this.medico = medico;
	}

	public String getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
