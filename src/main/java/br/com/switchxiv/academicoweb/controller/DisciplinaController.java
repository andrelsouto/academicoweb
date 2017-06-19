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

import br.com.switchxiv.academicoweb.dao.DisciplinaRepository;
import br.com.switchxiv.academicoweb.model.Disciplina;

@RequestMapping("/disciplina")
@Controller
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepo;
	
	@RequestMapping(value =  "/pagCadastroDisciplina", method = RequestMethod.GET)
	public ModelAndView pagCadastroDisciplina() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("disciplina/pagCadastroDisciplina");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/cadastrarDisciplina", method = RequestMethod.POST)
	public ModelAndView cadastrarCurso(Disciplina disciplina, BindingResult result, RedirectAttributes redirectAttributes){
		try {
			
			disciplinaRepo.save(disciplina);
			redirectAttributes.addFlashAttribute("cadastro", "sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:disciplina/pagCadastroDisciplina");
	}
	
	@RequestMapping(value = "/listagemDisciplina", method = RequestMethod.GET)
	public ModelAndView listagemDisciplina(){
		//Map<String, Object> disciplinasCursos = new HashMap<String, Object>();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		//List<Curso> cursos = new ArrayList<Curso>();
		
		try {
			disciplinas = disciplinaRepo.getListCurso();
			System.out.println(disciplinas);
			//cursos = cursoRepo.getList();
			//disciplinasCursos.put("disciplinas", disciplinas);
			//disciplinasCursos.put("cursos", cursos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView("disciplina/listagemDisciplina", "disciplinas", disciplinas);
	}
	
	@RequestMapping(value = "/editarDisciplina", method = RequestMethod.POST)
	public ModelAndView editarDisciplina(Disciplina disciplina, BindingResult result, RedirectAttributes redirectAttributes){
		try {
			
			disciplinaRepo.save(disciplina);
			redirectAttributes.addFlashAttribute("cadastro", "sucesso");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:disciplina/listagemDisciplina");
	}
	
	@RequestMapping(value = "/removerDisciplina", method = RequestMethod.POST)
	public ModelAndView removerDisciplina(Long id){
		
		try {
			disciplinaRepo.remove(disciplinaRepo.find(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:disciplina/listagemDisciplina");
	}
}