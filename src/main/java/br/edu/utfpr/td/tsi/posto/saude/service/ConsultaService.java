package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

public interface ConsultaService {
	public String validaConsulta(Consulta consulta);
	
	public void inserir(Consulta consulta);

	public void atualizar(Consulta consulta);

	public void remover(Consulta consulta);

	public List<Consulta> listarTodos();
	
	public Consulta procurarPeloId(String id);

}
