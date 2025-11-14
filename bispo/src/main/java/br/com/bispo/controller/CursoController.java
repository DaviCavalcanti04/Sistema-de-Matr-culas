package br.com.bispo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bispo.model.CursoModel;
import br.com.bispo.repository.CursoRepository;

@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepo;

	@GetMapping({"cursos/lista"})
	public String listarCursos(ModelMap model) {
		model.addAttribute("cursos", cursoRepo.findAll());
		return "cursos/lista";
	}

	@GetMapping("cursos/novo")
	public String novoCurso(ModelMap model) {
		model.addAttribute("cursoModel", new CursoModel());
		return "cursos/novo";
	}

	@PostMapping("cursos/salvar")
	public String salvarCurso(@ModelAttribute("cursoModel") CursoModel curso, RedirectAttributes redirectAttributes) {
		cursoRepo.save(curso);
		redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
		return "redirect:/cursos/lista";
	}
	
	
}
