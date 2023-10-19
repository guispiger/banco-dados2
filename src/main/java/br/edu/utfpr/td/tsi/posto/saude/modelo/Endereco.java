package br.edu.utfpr.td.tsi.posto.saude.modelo;

public class Endereco {
	private Long id;
	private String logradouro;
	private int numero;
	private String cep;
	private Bairro bairro;

	public Endereco() {
	}

	public Endereco(Long id, String logradouro, int numero, String cep, Bairro bairro) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return logradouro + ", " + numero + ", cep:" + cep + ", bairro: "
				+ bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}
