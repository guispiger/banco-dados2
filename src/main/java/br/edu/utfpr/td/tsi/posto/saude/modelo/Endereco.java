package br.edu.utfpr.td.tsi.posto.saude.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco", schema = "posto_saude")
public class Endereco {
	@Id
	@Column(name = "idEndereco", nullable = false, unique = true)
	private String id;

	@Column(name = "logradouro", length = 255, nullable = false)
	private String logradouro;

	@Column(name = "numero", nullable = false)
	private int numero;

	@Column(name = "cep", length = 45, nullable = false)
	private String cep;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bairroID", referencedColumnName = "idBairro")
	private Bairro bairro;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pacienteID", referencedColumnName = "idPaciente")
	private Paciente paciente;

	public Endereco() {
	}

	public Endereco(String id, String logradouro, int numero, String cep, Bairro bairro, Paciente paciente) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return logradouro + ", " + numero + ", cep:" + cep + ", bairro: " + bairro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
