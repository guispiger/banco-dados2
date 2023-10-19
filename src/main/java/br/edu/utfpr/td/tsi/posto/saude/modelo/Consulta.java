package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Consulta {
	private Long idConsulta;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dataHora;
	private String situacao;
	private Paciente paciente;
	private Medico medico;

	public Consulta() {
	}

	public Consulta(Long idConsulta, LocalDateTime dataHora, String situacao, Paciente paciente, Medico medico) {
		super();
		this.idConsulta = idConsulta;
		this.dataHora = dataHora;
		this.situacao = situacao;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
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
