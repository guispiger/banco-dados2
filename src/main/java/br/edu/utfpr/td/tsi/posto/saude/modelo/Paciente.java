package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "paciente", schema = "posto_saude")
public class Paciente {
	@Id
	@Column(name = "idpaciente", nullable = false, unique = true)
	private String id;

	@Column(name = "nome", length = 255)
	private String nome;

	@Column(name = "sobrenome", length = 255)
	private String sobrenome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

	@Column(name = "telefone", length = 45)
	private String telefone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idpaciente", referencedColumnName = "pacienteid")
	private Endereco endereco;

	public Paciente() {
	}

	public Paciente(String id, String nome, String sobrenome, LocalDate dataNascimento, String telefone,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento="
				+ dataNascimento + ", telefone=" + telefone + ", endereco=" + endereco + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
