package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;


public interface ConsultaDAO {

	public void inserir(Consulta consulta);

	public void atualizar(Consulta consulta);

	public void remover(Consulta consulta);

	public List<Consulta> listarTodos();
	
	public Consulta procurar(String id);
	
	public List<Consulta> procurarPorPaciente(Paciente p);
}
