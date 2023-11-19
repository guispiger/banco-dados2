package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public interface MedicoService {
	public void inserir(Medico medico);

	public void atualizar(Long idEspecialidade, Medico medico);

	public void remover(Medico medico);
	
	public List<Medico> listarTodos();
		
	public Medico procurar(String idMedico);
}
