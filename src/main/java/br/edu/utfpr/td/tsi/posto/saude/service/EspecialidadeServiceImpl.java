package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.EspecialidadeDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

@Service
public class EspecialidadeServiceImpl implements EspecialideService {

	@Autowired
	EspecialidadeDAO especialidadeDAO;
	
	@Override
	public void inserir(Especialidade especialidade) {
		String id = UUID.randomUUID().toString();
		especialidade.setIdEspecialidade(id);
		
		especialidadeDAO.inserir(especialidade);
		
	}

	@Override
	public void atualizar(Especialidade especialidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Especialidade especialidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Especialidade> listarTodos() {
		return especialidadeDAO.listarTodos();
	}

	@Override
	public Especialidade procurar(String id) {
		return especialidadeDAO.procurar(id);
	}

}
