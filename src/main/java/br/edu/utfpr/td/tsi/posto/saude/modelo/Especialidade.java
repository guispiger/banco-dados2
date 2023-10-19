package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Especialidade {
	private Long idEspecialidade;
	private String descricao;
	
	public Especialidade() {
	}

	public Especialidade(Long idEspecialidade, String descricao) {
		super();
		this.idEspecialidade = idEspecialidade;
		this.descricao = descricao;
	}

	public Long getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Long idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
