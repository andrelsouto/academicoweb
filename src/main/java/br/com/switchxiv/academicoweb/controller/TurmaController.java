package br.com.switchxiv.academicoweb.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.switchxiv.academicoweb.dao.TurmaRepository;

@Controller
@RequestMapping("/turma")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class TurmaController {

	@Autowired
	private TurmaRepository tRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView("turma/form");

		try {

			modelAndView.addObject("ano", LocalDate.now().getYear());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

}