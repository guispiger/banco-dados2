package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;


public interface ConsultaDAO {

	public void inserir(Consulta consulta, Long idPaciente, Long idMedico);

	public void atualizar(Consulta consulta, Long idPaciente, Long idMedico);

	public void remover(Long id);

	public List<Consulta> listarTodos();
	
	public Consulta procurar(Long id);
	
	public List<Consulta> procurarPorPaciente(Long idPaciente);
}
