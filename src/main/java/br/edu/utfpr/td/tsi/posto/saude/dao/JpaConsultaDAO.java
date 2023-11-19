package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.repository.ConsultaRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public class JpaConsultaDAO implements ConsultaDAO {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Override
	public void inserir(Consulta consulta) {
		consultaRepository.save(consulta);
		
	}

	@Override
	public void atualizar(Consulta consulta) {
		consultaRepository.save(consulta);
		
	}

	@Override
	public void remover(Consulta consulta) {
		consultaRepository.delete(consulta);
		
	}

	@Override
	public List<Consulta> listarTodos() {
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		Iterable<Consulta> consultas = consultaRepository.findAll();
		consultas.forEach(listaConsultas::add);
		return listaConsultas;
	}

	@Override
	public Consulta procurar(String id) {
		Consulta consultaLocalizada = new Consulta();
		Optional<Consulta> consulta = consultaRepository.findById(id);
		consultaLocalizada = consulta.get();
		return consultaLocalizada;
	}

	@Override
	public List<Consulta> procurarPorPaciente(Paciente p) {
		return consultaRepository.findByPaciente(p);
	}

}
