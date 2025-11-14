package br.com.bispo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bispo.model.ComponenteModel;
import br.com.bispo.model.CursoModel;
import br.com.bispo.repository.ComponenteRepository;
import br.com.bispo.repository.CursoRepository;

@Controller
public class ComponenteController {

	@Autowired
	private ComponenteRepository componenteRepo;

	@Autowired
	private CursoRepository cursoRepo;

	@GetMapping({ "componentes/lista" })
	public String listarComponente(ModelMap model) {
		model.addAttribute("componentes", componenteRepo.findAll());
		return "componentes/lista";
	}

	@GetMapping("componentes/novo")
	public String novoComponente(ModelMap model) {
		model.addAttribute("componenteModel", new ComponenteModel());
		model.addAttribute("cursos", cursoRepo.findAll());
		return "componentes/novo";
	}

	@PostMapping("componentes/salvar")
	public String salvarComponente(@ModelAttribute("componenteModel") ComponenteModel componente,
			RedirectAttributes redirectAttributes) {
		CursoModel curso = cursoRepo.findById(componente.getCurso().getCursoId()).get();
		componente.setCurso(curso);

		componenteRepo.save(componente);
		redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
		return "redirect:/componentes/lista";

	}

}
