package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.service.EspecialideService;
import br.edu.utfpr.td.tsi.posto.saude.service.MedicoService;

@Controller
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private EspecialideService especialidadeService;
	
	@GetMapping(value = "/cadastrarMedico")
	public String exibirPaginaCadastro(Model model) {
		List<Especialidade> especialidades = especialidadeService.listarTodos();
		model.addAttribute("especialidades", especialidades);
		return "cadastrarMedico";
	}
	
	@PostMapping(value = "/cadastrarMedico")
	public String cadastrarMedico(Medico medico) {
		medicoService.inserir(medico);
		return "redirect:/listarMedicos";
	}
	
	@GetMapping(value = "listarMedicos")
	public String listarMedicos(Model model) {
		List<Medico> medicos = medicoService.listarTodos();
		model.addAttribute("medicos", medicos);
		return "listarMedicos";
	}
	
}
