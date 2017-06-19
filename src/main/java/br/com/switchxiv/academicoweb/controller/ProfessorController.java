package br.com.switchxiv.academicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.switchxiv.academicoweb.dao.ProfessorRepository;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository pRepository;

	@RequestMapping(value="/cadastro", method=RequestMethod.GET)
	public ModelAndView cadastro(){
		
		return new ModelAndView("professor/form");
		
	}

}
