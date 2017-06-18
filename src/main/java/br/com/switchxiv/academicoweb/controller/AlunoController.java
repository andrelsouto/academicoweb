package br.com.switchxiv.academicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.AlunoRepository;
import br.com.switchxiv.academicoweb.model.Aluno;
import br.com.switchxiv.academicoweb.model.Endereco;
import br.com.switchxiv.academicoweb.model.Usuario;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository aRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("aluno/form");

		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Aluno aluno, BindingResult result, Usuario usuario, Endereco endereco,
			RedirectAttributes redirectAttributes) {
		try {

			aluno.setUsuario(usuario);
			usuario.setAluno(aluno);
			usuario.setEndereco(endereco);
			usuario.setSenha("123456");
			endereco.setUsuario(usuario);
			aRepository.save(aluno);
			redirectAttributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return new ModelAndView("redirect:/aluno/cadastro");

	}
	
	@RequestMapping(value="/lista", method = RequestMethod.GET)
	public ModelAndView lista(){
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("aluno/list");
		modelAndView.addObject("alunos", aRepository.list());
		
		return modelAndView;
	}

}
