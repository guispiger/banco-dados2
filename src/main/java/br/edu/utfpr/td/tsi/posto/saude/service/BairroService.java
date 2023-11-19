package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

public interface BairroService {
	public void inserir(Bairro bairro);

	public void atualizar(Bairro bairro);

	public void remover(Bairro bairro);

	public List<Bairro> listarTodos();
	
	public Bairro procurar(String id);
}
