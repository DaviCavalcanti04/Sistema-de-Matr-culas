package br.com.bispo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bispo.model.AlunoModel;
import br.com.bispo.repository.AlunoRepository;
import br.com.bispo.repository.MatriculaRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepo;

	@Autowired
	private MatriculaRepository matriculaRepo;

	@GetMapping({"/", "alunos/lista"})
	public String listarAlunos(ModelMap model) {
		model.addAttribute("alunos", alunoRepo.findAll());
		return "alunos/lista";
	}

	@GetMapping("alunos/novo")
	public String novoAluno(ModelMap model) {
		model.addAttribute("alunoModel", new AlunoModel());
		return "alunos/novo";
	}

	@PostMapping("alunos/salvar")
	public String salvarAluno(@ModelAttribute("alunoModel") AlunoModel aluno, RedirectAttributes redirectAttributes) {
		alunoRepo.save(aluno);
		redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
		return "redirect:/";
	}
	
	
}
