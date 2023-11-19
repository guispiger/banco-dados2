package br.edu.utfpr.td.tsi.posto.saude.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface ConsultaRepository extends CrudRepository<Consulta, String> {
	
	public List<Consulta> findByPaciente(Paciente p);

}
