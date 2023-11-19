package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

@Service
public class MedicoServiceImpl implements MedicoService {
	
	@Autowired
	MedicoDAO medicoDAO;
	
	@Override
	public void inserir(Medico medico) {
		String id = UUID.randomUUID().toString();
		medico.setIdMedico(id);
		
		medicoDAO.inserir(medico);
	}

	@Override
	public void atualizar(Long idEspecialidade, Medico medico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Medico medico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medico> listarTodos() {
		return medicoDAO.listarTodos();
	}

	@Override
	public Medico procurar(String idMedico) {
		return medicoDAO.procurar(idMedico);
	}

}
