package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Controller
public class ConsultaController {

	@Autowired
	private ConsultaDAO consultaDAO;

	@Autowired
	private PacienteDAO pacienteDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	@GetMapping(value = "/cadastrarConsulta")
	public String exibirPaginaCadastro(Model model) {
		List<Paciente> pacientes = pacienteDAO.listarTodos();
		List<Medico> medicos = medicoDAO.listarTodos();
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("medicos", medicos);
		return "cadastrarConsulta";
	}

	@PostMapping(value = "/cadastrarConsulta")
	public String cadastrar(Consulta c, Model model) {
		List<Paciente> pacientes = pacienteDAO.listarTodos();
		List<Medico> medicos = medicoDAO.listarTodos();
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("medicos", medicos);
		
		String mensagem = null;
		List<Consulta> consultas = consultaDAO.procurarPorPaciente(c.getPaciente().getId());

		if (consultas != null) {
			for (Consulta consulta : consultas) {
				if (consulta.getSituacao().equalsIgnoreCase("agendada")) {
					mensagem = "Paciente não pode marcar nova consulta pois já possui uma consulta marcada!!";
					model.addAttribute("mensagem", mensagem);
					return "cadastrarConsulta";
				}
			}
		}

		c.setSituacao("agendada");
		consultaDAO.inserir(c, c.getPaciente().getId(), c.getMedico().getIdMedico());
		return "redirect:/listarConsultas";
	}
	
	
	@GetMapping(value = "/atualizarConsulta")
	public String exibirPaginaAtualizarConsulta(String id, Model model) {
		List<Paciente> pacientes = pacienteDAO.listarTodos();
		List<Medico> medicos = medicoDAO.listarTodos();
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("medicos", medicos);
		
		Consulta c = consultaDAO.procurar(Long.valueOf(id));
		model.addAttribute("consulta", c);
		
		return "atualizarConsulta";
	}
	
	@PostMapping(value = "/atualizarConsulta")
	public String atualizarConsulta(Consulta c) {
		consultaDAO.atualizar(c, c.getPaciente().getId(), c.getMedico().getIdMedico());
		return "redirect:/listarConsultas";
	}
	
	@PostMapping(value = "/removerConsulta")
	public String removerConsulta(String id) {
		Consulta c = consultaDAO.procurar(Long.valueOf(id));
		consultaDAO.remover(c.getIdConsulta());
		return "redirect:/listarConsultas";
	}
	

	@GetMapping(value = "/listarConsultas")
	public String listarPacientes(Model model) {
		List<Consulta> consultas = consultaDAO.listarTodos();
		model.addAttribute("consultas", consultas);
		return "listarConsultas";
	}

}
