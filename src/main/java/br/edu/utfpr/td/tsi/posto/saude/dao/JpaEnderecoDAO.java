package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.repository.EnderecoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public class JpaEnderecoDAO implements EnderecoDAO {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Override
	public void inserir(Endereco endereco, String idPaciente) {
		enderecoRepository.save(endereco);
		
	}

	@Override
	public void atualizar(String idPaciente, Endereco endereco) {
		enderecoRepository.save(endereco);
		
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listarTodos() {
		List<Endereco> lsitaEnderecos = new ArrayList<Endereco>();
		Iterable<Endereco> enderecos = enderecoRepository.findAll();
		enderecos.forEach(lsitaEnderecos::add);
		return lsitaEnderecos;
	}

	@Override
	public Endereco procurarPorPacienteId(String idPaciente) {
		return enderecoRepository.findByPacienteId(idPaciente);
	}

}
