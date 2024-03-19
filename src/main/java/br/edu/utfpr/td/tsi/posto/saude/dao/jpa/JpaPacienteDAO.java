package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
//import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public class JpaPacienteDAO implements PacienteDAO {

	@Autowired
	private PacienteRepository pacienteRepository;
	
//	@Autowired
//	private EnderecoRepository enderecoRepository;

	@Override
	public void inserir(Paciente p) {
		pacienteRepository.save(p);

	}

	@Override
	public void atualizar(String id, Paciente p) {
		pacienteRepository.save(p);

	}

	@Override
	public void remover(Paciente p) {
		pacienteRepository.delete(p);

	}

	@Override
	public List<Paciente> listarTodos() {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		Iterable<Paciente> pacientes = pacienteRepository.findAll();
//		pacientes.forEach(paciente -> {
//				Endereco end = enderecoRepository.findByPaciente(paciente);
//				paciente.setEndereco(end);
//		});
		pacientes.forEach(listaPacientes::add);
		return listaPacientes;
	}

	@Override
	public Paciente procurar(String id) {
		Paciente pacienteLocalizado = new Paciente();
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		pacienteLocalizado = paciente.get();
		return pacienteLocalizado;
	}

}
