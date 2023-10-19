package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Paciente {
	private Long id;
	private String nome;
	private String sobrenome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	private String telefone;
	private Endereco endereco;

	public Paciente() {
	}

	public Paciente(Long id, String nome, String sobrenome, LocalDate dataNascimento, String telefone,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
