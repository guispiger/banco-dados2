package br.edu.utfpr.td.tsi.posto.saude.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bairro", schema = "posto_saude")
public class Bairro {
	@Id
	@Column(name = "idBairro", nullable = false, unique = true)
	private String id;

	@Column(name = "nome", length = 255, nullable = false)
	private String nome;

	public Bairro() {

	}

	public Bairro(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
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

}
