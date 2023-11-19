package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

public interface EspecialidadeDAO {
	public void inserir(Especialidade especialidade);

	public void atualizar(Especialidade especialidade);

	public void remover(Especialidade especialidade);

	public List<Especialidade> listarTodos();
	
	public Especialidade procurar(String id);

}
