package br.edu.utfpr.td.tsi.posto.saude.dao;


import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public interface EnderecoDAO {

	public void inserir(Endereco endereco, String idPaciente);

	public void atualizar(String idPaciente, Endereco endereco);

	public void remover(String id);
	
	public List<Endereco> listarTodos();
		
	public Endereco procurarPorPacienteId(String idPaciente);

}
