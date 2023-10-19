package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.dao.EspecialidadeDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Especialidade;

@Controller
public class EspecialidadeController {
	
	@Autowired
	EspecialidadeDAO especialidadeDAO;
	
	@GetMapping(value = "/listarEspecialidades")
	public String listarEspecialidades(Model model) {
		List<Especialidade> especialidades = especialidadeDAO.listarTodos();
		model.addAttribute("especialidades", especialidades);
		return "listarEspecialidades";
	}
	
	@GetMapping(value = "/cadastrarEspecialidade")
	public String exibirPaginaCadastro() {
		return "cadastrarEspecialidade";
	}
	
	@PostMapping(value = "/cadastrarEspecialidade")
	public String cadastrarEspecialidade(Especialidade especialidade) {
		especialidadeDAO.inserir(especialidade);		
		return "redirect:/listarEspecialidades";
	}

}
