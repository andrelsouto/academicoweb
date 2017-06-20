package br.com.switchxiv.academicoweb.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.switchxiv.academicoweb.dao.ProfessorRepository;
import br.com.switchxiv.academicoweb.dao.TurmaRepository;

@Controller
@RequestMapping("/turma")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TurmaController {

	@Autowired
	private TurmaRepository tRepository;
	@Autowired
	private ProfessorRepository pRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView("turma/form");

		try {

			modelAndView.addObject("ano", LocalDate.now().getYear());
			modelAndView.addObject("professores", pRepository.list());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

	@RequestMapping(value = "cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Long professor[]) {
		
		
		return new ModelAndView("redirect:/turma/cadastro");
	}

}
