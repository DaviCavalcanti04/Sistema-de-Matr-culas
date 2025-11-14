package br.com.bispo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bispo.model.ComponenteModel;
import br.com.bispo.model.TurmaModel;
import br.com.bispo.repository.ComponenteRepository;
import br.com.bispo.repository.TurmaRepository;

@Controller
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepo;

	@Autowired
	private ComponenteRepository componenteRepo;

	@GetMapping({ "turmas/lista" })
	public String listarTurmas(ModelMap model) {
		model.addAttribute("turmas", turmaRepo.findAll());
		return "turmas/lista";
	}

	@GetMapping("turmas/novo")
	public String novaTurma(ModelMap model) {
		model.addAttribute("turmaModel", new TurmaModel());
		model.addAttribute("componentes", componenteRepo.findAll());
		return "turmas/novo";
	}

	@PostMapping("turmas/salvar")
	public String salvarTurma(@ModelAttribute("turmaModel") TurmaModel turma,
			RedirectAttributes redirectAttributes) {
		ComponenteModel componente = componenteRepo.findById(turma.getComponente().getComponenteId()).get();
		turma.setComponente(componente);

		turmaRepo.save(turma);
		redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
		return "redirect:/turmas/lista";

	}

}
