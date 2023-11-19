package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.BairroService;
import br.edu.utfpr.td.tsi.posto.saude.service.PacienteService;

@Controller
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private BairroService bairroService;

	@GetMapping(value = "/cadastrarPaciente")
	public String exibirPaginaCadastro(Model model) {
		List<Bairro> bairros = bairroService.listarTodos();
		model.addAttribute("bairros", bairros);
		return "cadastrarPaciente";
	}

	@PostMapping("/cadastrarPaciente")
	public String cadastrar(Paciente p) {
		pacienteService.inserir(p);
		return "redirect:/listarPacientes";
	}
	
	@GetMapping(value = "/listarPacientes")
	public String listarPacientes(Model model) {
		List<Paciente> pacientes = pacienteService.listarTodos();
		model.addAttribute("pacientes", pacientes);
		return "listarPacientes";
	}

}
