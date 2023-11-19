package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;
import br.edu.utfpr.td.tsi.posto.saude.service.BairroService;

@Controller
public class BairroController {

	@Autowired
	private BairroService bairroService;

	@GetMapping(value = "/listarbairros")
	public String listar(Model model) {
		List<Bairro> bairros = bairroService.listarTodos();
		model.addAttribute("bairros", bairros);	
		return "listarBairros";
	}

	@GetMapping(value = "/cadastrarbairro")
	public String exibirPaginaCadastro() {
		return "cadastrarBairro";
	}

	@PostMapping("/cadastrarBairro")
	public String cadastrar(Bairro bairro) {
		bairroService.inserir(bairro);
		return "redirect:/listarbairros";
	}
	
	@PostMapping("/removerBairro")
	public String remover(Bairro bairro) {
		bairroService.remover(bairro);
		return "redirect:/listarbairros";
	}

}
