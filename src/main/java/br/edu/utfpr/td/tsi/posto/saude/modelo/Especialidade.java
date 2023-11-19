package br.edu.utfpr.td.tsi.posto.saude.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "especialidade", schema = "posto_saude")
public class Especialidade {
	@Id
	@Column(name = "idEspecialidade", nullable = false, unique = true)
	private String idEspecialidade;

	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;

	public Especialidade() {
	}

	public Especialidade(String idEspecialidade, String descricao) {
		super();
		this.idEspecialidade = idEspecialidade;
		this.descricao = descricao;
	}

	public String getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(String idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
