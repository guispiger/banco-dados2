package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.EnderecoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteDAO pacienteDao;
	
	@Autowired
	private EnderecoDAO enderecoDAO;
	
	@Override
	@Transactional
	public void inserir(Paciente p) {	
		String idPaciente = UUID.randomUUID().toString();
		p.setId(idPaciente);
		
		String idEndereco = UUID.randomUUID().toString();
		p.getEndereco().setId(idEndereco);
		
		p.getEndereco().setPaciente(p);
		
		pacienteDao.inserir(p);
	}

	@Override
	public void atualizar(String id, Paciente p) {
		pacienteDao.atualizar(id, p);
		
	}

	@Override
	public void remover(Paciente p) {
		pacienteDao.remover(p);
		
	}

	@Override
	public List<Paciente> listarTodos() {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		
		listaPacientes = pacienteDao.listarTodos();
		
		for (Paciente paciente : listaPacientes) {
			Endereco end = enderecoDAO.procurarPorPacienteId(paciente.getId());
			paciente.setEndereco(end);
		}
		return listaPacientes;
	}

	@Override
	public Paciente procurar(String id) {
		return pacienteDao.procurar(id);
	}
	
	

}
