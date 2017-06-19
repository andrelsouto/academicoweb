package br.com.switchxiv.academicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.ProfessorRepository;
import br.com.switchxiv.academicoweb.model.Endereco;
import br.com.switchxiv.academicoweb.model.Professor;
import br.com.switchxiv.academicoweb.model.Usuario;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository pRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		return new ModelAndView("professor/form");

	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Professor professor, BindingResult result, Usuario usuario, Endereco endereco,
			RedirectAttributes attributes) {

		try {

			professor.setUsuario(usuario);
			usuario.setProfessor(professor);
			usuario.setEndereco(endereco);
			endereco.setUsuario(usuario);
			pRepository.save(professor);
			attributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/professor/cadastro");

	}

}
