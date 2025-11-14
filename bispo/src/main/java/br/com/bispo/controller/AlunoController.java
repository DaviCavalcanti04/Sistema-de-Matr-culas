package br.com.bispo.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping({ "/", "alunos/lista" })
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
		if (aluno.getNomeAluno() == null || aluno.getNomeAluno().isBlank() || aluno.getNascimento() == null) {
			redirectAttributes.addFlashAttribute("erro", "Preencha todos os campos obrigatórios.");
			redirectAttributes.addFlashAttribute("alunoModel", aluno);
			return "redirect:/alunos/novo";
		}

		if (Period.between(aluno.getNascimento(), LocalDate.now()).getYears() < 13) {
			redirectAttributes.addFlashAttribute("erro", "Idade mínima é 13 anos.");
			redirectAttributes.addFlashAttribute("alunoModel", aluno);
			return "redirect:/alunos/novo";
		}

		if (aluno.getCpf() == null || aluno.getCpf().length() != 14) {
			redirectAttributes.addFlashAttribute("erro", "CPF inválido.");
			redirectAttributes.addFlashAttribute("alunoModel", aluno);
			return "redirect:/alunos/novo";

		}
		String tel = aluno.getTelefone() == null ? "" : aluno.getTelefone();
		if (!tel.isBlank() && tel.length() < 10) {
			redirectAttributes.addFlashAttribute("erro", "Telefone invalido.");
			redirectAttributes.addFlashAttribute("alunoModel", aluno);
			return "redirect:/alunos/novo";
		}
		alunoRepo.save(aluno);
		redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
		return "redirect:/alunos/lista";
	}

	@GetMapping("/alunos/matriculas")
	public String listarMatriculasDoAluno(@RequestParam("id") Long id, ModelMap model) {
	    var aluno = alunoRepo.findById(id);
	    if (aluno.isPresent()) {
	        model.addAttribute("matriculas", matriculaRepo.findByAluno(aluno.get()));
	        model.addAttribute("aluno", aluno.get());
	    } else {
	        model.addAttribute("matriculas", List.of());
	        model.addAttribute("erro", "Aluno não encontrado.");
	    }
	    return "matriculas/lista";
	}
}