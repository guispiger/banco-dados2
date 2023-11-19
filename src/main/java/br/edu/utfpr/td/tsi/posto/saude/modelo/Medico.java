package br.edu.utfpr.td.tsi.posto.saude.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medico", schema = "posto_saude")
public class Medico {
	@Id
	@Column(name = "idMedico", nullable = false, unique = true)
	private String idMedico;

	@Column(name = "nome", length = 255)
	private String nome;

	@Column(name = "sobrenome", length = 45)
	private String sobrenome;

	@Column(name = "telefone", length = 45)
	private String telefone;

	@Column(name = "crm", length = 45)
	private String crm;

	@Column(name = "cpf", length = 45)
	private String cpf;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "especialidadeId", referencedColumnName = "idEspecialidade")
	private Especialidade especialidade;

	public Medico() {
	}

	public Medico(String idMedico, String nome, String sobrenome, String telefone, String crm, String cpf,
			Especialidade especialidade) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.crm = crm;
		this.cpf = cpf;
		this.especialidade = especialidade;
	}

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone
				+ ", crm=" + crm + ", cpf=" + cpf + ", especialidade=" + especialidade + "]";
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
