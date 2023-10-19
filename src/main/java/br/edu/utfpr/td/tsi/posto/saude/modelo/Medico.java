package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Medico {
	private Long idMedico;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String crm;
	private String cpf;
	private Especialidade especialidade;
	
	public Medico() {
	}

	public Medico(Long idMedico, String nome, String sobrenome, String telefone, String crm, String cpf,
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

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
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
