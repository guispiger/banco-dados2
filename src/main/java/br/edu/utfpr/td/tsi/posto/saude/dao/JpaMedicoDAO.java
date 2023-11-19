package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.repository.MedicoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public class JpaMedicoDAO implements MedicoDAO {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public void inserir(Medico medico) {
		medicoRepository.save(medico);
		
	}

	@Override
	public void atualizar(Long idEspecialidade, Medico medico) {
		medicoRepository.save(medico);
		
	}

	@Override
	public void remover(Medico medico) {
		medicoRepository.delete(medico);
		
	}

	@Override
	public List<Medico> listarTodos() {
		List<Medico> listaMedicos = new ArrayList<Medico>();
		Iterable<Medico> medicos = medicoRepository.findAll();
		medicos.forEach(listaMedicos::add);
		return listaMedicos;
	}

	@Override
	public Medico procurar(String idMedico) {
		Medico medico = new Medico();
		Optional<Medico> paciente = medicoRepository.findById(idMedico);
		medico = paciente.get();
		return medico;
	}

}
