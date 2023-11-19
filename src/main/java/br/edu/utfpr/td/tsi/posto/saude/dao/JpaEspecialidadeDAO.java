package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.repository.EspecialidadeRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

public class JpaEspecialidadeDAO implements EspecialidadeDAO {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Override
	public void inserir(Especialidade especialidade) {
		especialidadeRepository.save(especialidade);

	}

	@Override
	public void atualizar(Especialidade especialidade) {
		especialidadeRepository.save(especialidade);

	}

	@Override
	public void remover(Especialidade especialidade) {
		especialidadeRepository.delete(especialidade);

	}

	@Override
	public List<Especialidade> listarTodos() {
		List<Especialidade> listaEspecialidades = new ArrayList<Especialidade>();
		Iterable<Especialidade> especialidades = especialidadeRepository.findAll();
		especialidades.forEach(listaEspecialidades::add);
		return listaEspecialidades;
	}

	@Override
	public Especialidade procurar(String id) {
		return especialidadeRepository.findByidEspecialidade(id);
	}

}
