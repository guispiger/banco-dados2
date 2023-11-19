package br.edu.utfpr.td.tsi.posto.saude.dao.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {
	
	public Endereco findByPaciente(Paciente paciente);
	
	public Endereco findByPacienteId(String idPaciente);
}
