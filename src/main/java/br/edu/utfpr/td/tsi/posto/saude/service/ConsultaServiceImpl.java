package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

@Service
public class ConsultaServiceImpl implements ConsultaService {
	
	@Autowired
	ConsultaDAO consultaDAO;
	
	@Override
	public void inserir(Consulta consulta) {	
		String id = UUID.randomUUID().toString();
		consulta.setIdConsulta(id);
		
		consulta.setSituacao("agendada");
		
		consultaDAO.inserir(consulta);
		
	}
	
	@Override
	public String validaConsulta(Consulta consulta) {
		String msg = null;
		List<Consulta> consultas = consultaDAO.procurarPorPaciente(consulta.getPaciente());
		
		if (consultas != null) {
			for (Consulta c : consultas) {
				if (c.getSituacao().equalsIgnoreCase("agendada")) {
					msg = "Paciente não pode marcar nova consulta pois já possui uma consulta marcada!!";
					break;
				} else if(c.getDataHora().compareTo(consulta.getDataHora()) == 0) {
					msg = "Paciente já possui uma consulta nesse horário!!";
					break;
				}
			}
		}	
		return msg;
	}
	
	

	@Override
	public void atualizar(Consulta consulta) {
		consultaDAO.atualizar(consulta);
	}

	@Override
	public void remover(Consulta consulta) {
		consultaDAO.remover(consulta);
		
	}

	@Override
	public List<Consulta> listarTodos() {
		return consultaDAO.listarTodos();
	}

	@Override
	public Consulta procurarPeloId(String id) {
		return consultaDAO.procurar(id);
	}
	

}
