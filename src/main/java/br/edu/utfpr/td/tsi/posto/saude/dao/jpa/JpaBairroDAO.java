package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

public class JpaBairroDAO implements BairroDAO {
	
	@Autowired
	private BairroRepository bairroRepository;

	@Override
	public void inserir(Bairro bairro) {
		bairroRepository.save(bairro);
		
	}

	@Override
	public void atualizar(Bairro bairro) {
		bairroRepository.save(bairro);
		
	}

	@Override
	public void remover(Bairro bairro) {
		bairroRepository.delete(bairro);
		
	}

	@Override
	public List<Bairro> listarTodos() {
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		Iterable<Bairro> bairros = bairroRepository.findAll();
		bairros.forEach(listaBairros::add);
		return listaBairros;
	}

	@Override
	public Bairro procurar(String id) {
		Bairro bairroLocalizado = new Bairro();
		Optional<Bairro> bairro = bairroRepository.findById(id);
		bairroLocalizado = bairro.get();
		return bairroLocalizado;
	}

}
