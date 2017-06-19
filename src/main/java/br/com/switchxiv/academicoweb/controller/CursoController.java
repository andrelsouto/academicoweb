package br.com.switchxiv.academicoweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.CursoRepository;
import br.com.switchxiv.academicoweb.model.Curso;

@RequestMapping("/curso")
@Controller
public class CursoController {

	@Autowired
	private CursoRepository cursoRepo;
	
	
	@RequestMapping(value =  "/pagCadastroCurso", method = RequestMethod.GET)
	public ModelAndView pagCadastroCurso() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("curso/pagCadastroCurso");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastrarCurso", method = RequestMethod.POST)
	public ModelAndView cadastrarCurso(Curso curso, BindingResult result, RedirectAttributes redirectAttributes){
		try {
			
			cursoRepo.save(curso);
			redirectAttributes.addFlashAttribute("cadastro", "sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:curso/pagCadastroCurso");
	}
	
	@RequestMapping(value = "/listagemCurso", method = RequestMethod.GET)
	public ModelAndView listagemCurso(){
		List<Curso> cursos = new ArrayList<Curso>();
		
		try {
			cursos = cursoRepo.getList();
			System.out.println(cursos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("curso/listagemCurso", "cursos", cursos);
	}
	
	@RequestMapping(value = "/editarCurso", method = RequestMethod.POST)
	public ModelAndView editarCurso(Curso curso, BindingResult result, RedirectAttributes redirectAttributes){
		try {
			
			cursoRepo.save(curso);
			redirectAttributes.addFlashAttribute("cadastro", "sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:curso/listagemCurso");
	}
	
	@RequestMapping(value = "/removerCurso", method = RequestMethod.POST)
	public ModelAndView removerCurso(Long id){
		
		try {
			cursoRepo.remove(cursoRepo.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:curso/listagemCurso");
	}
}
