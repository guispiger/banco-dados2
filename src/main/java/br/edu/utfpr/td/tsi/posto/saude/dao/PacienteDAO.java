package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface PacienteDAO {

	public void inserir(Paciente p);

	public void atualizar(String id, Paciente p);

	public void remover(Paciente p);

	public List<Paciente> listarTodos();
	
	public Paciente procurar(String id);

}
