package br.com.switchxiv.academicoweb.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.DisciplinaRepository;
import br.com.switchxiv.academicoweb.dao.ProfessorRepository;
import br.com.switchxiv.academicoweb.dao.TurmaRepository;
import br.com.switchxiv.academicoweb.model.Turma;

@Controller
@RequestMapping("/turma")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TurmaController {

	@Autowired
	private TurmaRepository tRepository;
	@Autowired
	private ProfessorRepository pRepository;
	@Autowired
	private DisciplinaRepository dRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView("turma/form");

		try {

			modelAndView.addObject("ano", LocalDate.now().getYear());
			modelAndView.addObject("professores", pRepository.list());
			modelAndView.addObject("disciplinas", dRepository.getList());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Turma turma, BindingResult result, Long professor, Long disciplina,
			RedirectAttributes attributes) {
		try {
			
			turma.setDisciplina(dRepository.find(disciplina));
			turma.setProfessor(pRepository.find(professor));
			tRepository.save(turma);
			attributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/turma/cadastro");
	}

}
