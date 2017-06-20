package br.com.switchxiv.academicoweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.CursoRepository;
import br.com.switchxiv.academicoweb.dao.ProfessorRepository;
import br.com.switchxiv.academicoweb.model.Curso;
import br.com.switchxiv.academicoweb.model.Endereco;
import br.com.switchxiv.academicoweb.model.Professor;
import br.com.switchxiv.academicoweb.model.Usuario;

@Controller
@RequestMapping("/professor")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class ProfessorController {

	@Autowired
	private ProfessorRepository pRepository;
	@Autowired
	private CursoRepository cRepository;

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
			usuario.setSenha("123456");
			endereco.setUsuario(usuario);
			pRepository.save(professor);
			attributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/professor/cadastro");

	}

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("professor/list");

		try {

			modelAndView.addObject("professores", pRepository.list());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;

	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(Professor professor, BindingResult result, Usuario usuario, Endereco endereco,
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

		return new ModelAndView("redirect:/professor/lista");

	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(Long id, RedirectAttributes attributes) {
		try {

			pRepository.remove(pRepository.find(id));
			attributes.addFlashAttribute("exclusao", "sucesso");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return new ModelAndView("redirect:/professor/lista");
	}

	@RequestMapping(value = "/addCurso", method = RequestMethod.GET)
	public ModelAndView addCurso() {

		ModelAndView modelAndView = new ModelAndView("professor/addCurso");

		try {

			modelAndView.addObject("cursos", cRepository.getList());
			modelAndView.addObject("professores", pRepository.list());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public ModelAndView adiciona(Long curso, Long professor, RedirectAttributes attributes) {

		ModelAndView modelAndView = new ModelAndView("redirect:/professor/addCurso");

		try {

			Curso c = cRepository.findWithProfessores(curso);
			Professor p = pRepository.find(professor);
			if(c.getProfessores() != null){
				List<Professor> professores = c.getProfessores();
				professores.add(p);
				c.setProfessores(professores);
			}
			else {
				List<Professor> professores = new ArrayList<Professor>();
				professores.add(p);
				c.setProfessores(professores);
			}
			cRepository.save(c);
			attributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

}
