package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.EspecialidadeDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

@Controller
public class MedicoController {

	@Autowired
	private MedicoDAO medicoDAO;
	
	@Autowired
	private EspecialidadeDAO especialidadeDAO;
	
	@GetMapping(value = "/cadastrarMedico")
	public String exibirPaginaCadastro(Model model) {
		List<Especialidade> especialidades = especialidadeDAO.listarTodos();
		model.addAttribute("especialidades", especialidades);
		return "cadastrarMedico";
	}
	
	@PostMapping(value = "/cadastrarMedico")
	public String cadastrarMedico(Medico medico) {
		medicoDAO.inserir(medico);
		return "redirect:/listarMedicos";
	}
	
	@GetMapping(value = "listarMedicos")
	public String listarMedicos(Model model) {
		List<Medico> medicos = medicoDAO.listarTodos();
		model.addAttribute("medicos", medicos);
		return "listarMedicos";
	}
	
}
