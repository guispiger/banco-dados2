package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

public interface EspecialidadeRepository extends CrudRepository<Especialidade, String> {
	
	public Especialidade findByidEspecialidade(String id); 
}
