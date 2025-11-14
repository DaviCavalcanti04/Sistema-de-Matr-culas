package br.com.bispo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bispo.model.MatriculaModel;
import br.com.bispo.repository.AlunoRepository;
import br.com.bispo.repository.MatriculaRepository;
import br.com.bispo.repository.TurmaRepository;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepo;

    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private TurmaRepository turmaRepo;

    @GetMapping({ "matriculas/lista" })
    public String listarMatriculas(ModelMap model) {
        model.addAttribute("matriculas", matriculaRepo.findAll());
        return "matriculas/lista";
    }

    @GetMapping("matriculas/novo")
    public String novaMatricula(ModelMap model) {
        model.addAttribute("matriculaModel", new MatriculaModel());
        model.addAttribute("alunos", alunoRepo.findAll());
        model.addAttribute("turmas", turmaRepo.findAll());
        return "matriculas/novo";
    }

    @PostMapping("matriculas/salvar")
    public String salvarMatricula(@ModelAttribute("matriculaModel") MatriculaModel matricula, RedirectAttributes redirectAttributes) {
        matricula.setData_matricula(new java.sql.Date(System.currentTimeMillis()));
    	matriculaRepo.save(matricula);
        redirectAttributes.addFlashAttribute("mensagem", "Operação realizada com sucesso!");
        return "redirect:/matriculas/lista";
    }
}
