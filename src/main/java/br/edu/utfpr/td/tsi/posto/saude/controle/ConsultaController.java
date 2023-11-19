package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.ConsultaService;
import br.edu.utfpr.td.tsi.posto.saude.service.MedicoService;
import br.edu.utfpr.td.tsi.posto.saude.service.PacienteService;


@Controller
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private MedicoService medicoService;

	@GetMapping(value = "/cadastrarConsulta")
	public String exibirPaginaCadastro(Model model, String mensagem) {
		List<Paciente> pacientes = pacienteService.listarTodos();
		List<Medico> medicos = medicoService.listarTodos();
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("medicos", medicos);
		model.addAttribute("mensagem", mensagem);
		return "cadastrarConsulta";
	}

	@PostMapping(value = "/cadastrarConsulta")
	public String cadastrar(Consulta c, Model model) {		
		String mensagem = consultaService.validaConsulta(c);
		
		if (mensagem != null) {
			exibirPaginaCadastro(model, mensagem);
			return "cadastrarConsulta";
		}

		consultaService.inserir(c);
		return "redirect:/listarConsultas";
	}
	
	
	@GetMapping(value = "/atualizarConsulta")
	public String exibirPaginaAtualizarConsulta(String id, Model model) {
		List<Paciente> pacientes = pacienteService.listarTodos();
		List<Medico> medicos = medicoService.listarTodos();
		model.addAttribute("pacientes", pacientes);
		model.addAttribute("medicos", medicos);
		
		Consulta c = consultaService.procurarPeloId(id);
		
		model.addAttribute("consulta", c);
		
		return "atualizarConsulta";
	}
	
	@PostMapping(value = "/atualizarConsulta")
	public String atualizarConsulta(Consulta c) {
		consultaService.atualizar(c);
		return "redirect:/listarConsultas";
	}
	
	@PostMapping(value = "/removerConsulta")
	public String removerConsulta(String id) {
		Consulta c = consultaService.procurarPeloId(id);
		consultaService.remover(c);
		return "redirect:/listarConsultas";
	}
	

	@GetMapping(value = "/listarConsultas")
	public String listarPacientes(Model model) {
		List<Consulta> consultas = consultaService.listarTodos();
		model.addAttribute("consultas", consultas);
		return "listarConsultas";
	}

}
