package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Bairro {

	private Long id;
	private String nome;

	public Bairro() {

	}

	public Bairro(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return  nome;
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

}
