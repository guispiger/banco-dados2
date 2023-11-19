package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Service
public class BairroServiceImpl implements BairroService {

	@Autowired
	private BairroDAO bairroDao;
	
	@Override
	public void inserir(Bairro bairro) {
		String id = UUID.randomUUID().toString();
		bairro.setId(id);
		bairroDao.inserir(bairro);
	}

	@Override
	public void atualizar(Bairro bairro) {
		bairroDao.atualizar(bairro);
	}

	@Override
	public void remover(Bairro bairro) {
		bairroDao.remover(bairro);
	}

	@Override
	public List<Bairro> listarTodos() {
		return bairroDao.listarTodos();
	}

	@Override
	public Bairro procurar(String id) {
		return bairroDao.procurar(id);
	}

}
