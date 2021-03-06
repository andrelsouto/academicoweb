package br.com.switchxiv.academicoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.switchxiv.academicoweb.dao.AlunoRepository;
import br.com.switchxiv.academicoweb.dao.CursoRepository;
import br.com.switchxiv.academicoweb.dao.DesempenhoRepository;
import br.com.switchxiv.academicoweb.dao.TurmaRepository;
import br.com.switchxiv.academicoweb.model.Aluno;
import br.com.switchxiv.academicoweb.model.Desempenho;
import br.com.switchxiv.academicoweb.model.Endereco;
import br.com.switchxiv.academicoweb.model.Usuario;

@Controller
@RequestMapping("/aluno")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class AlunoController {

	@Autowired
	private AlunoRepository aRepository;
	@Autowired
	private CursoRepository cRepository;
	@Autowired
	private TurmaRepository tRepository;
	@Autowired
	private DesempenhoRepository dRepository;

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cursos", cRepository.getList());
		modelAndView.setViewName("aluno/form");

		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrar(Aluno aluno, BindingResult result, Usuario usuario, Endereco endereco, Long curso_id,
			RedirectAttributes redirectAttributes) {
		try {

			aluno.setUsuario(usuario);
			aluno.setCurso(cRepository.find(curso_id));
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

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public ModelAndView lista() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("aluno/list");
		modelAndView.addObject("alunos", aRepository.list());
		modelAndView.addObject("cursos", cRepository.getList());

		return modelAndView;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(Aluno aluno, BindingResult result, Usuario usuario, Endereco endereco, Long curso_id,
			RedirectAttributes attributes) {
		try {

			aluno.setUsuario(usuario);
			aluno.setCurso(cRepository.find(curso_id));
			usuario.setAluno(aluno);
			usuario.setEndereco(endereco);
			endereco.setUsuario(usuario);
			aRepository.save(aluno);
			attributes.addFlashAttribute("cadastro", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/aluno/lista");

	}

	@RequestMapping(value = "/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(Long id, RedirectAttributes attributes) {
		try {

			aRepository.remove(aRepository.find(id));
			attributes.addFlashAttribute("exclusao", "sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/aluno/lista");
	}

	@RequestMapping(value = "/addTurma", method=RequestMethod.GET)
	public ModelAndView addTurma() {

		ModelAndView andView = new ModelAndView("aluno/addTurma");

		try {

			andView.addObject("alunos", aRepository.list());
			andView.addObject("turmas", tRepository.list());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return andView;

	}
	
	@RequestMapping(value = "/adicionar", method=RequestMethod.POST)
	public ModelAndView adicionar(Long turma,Long aluno, RedirectAttributes attributes) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/aluno/addTurma");
		
		try {
			
			Desempenho d = new Desempenho();
			d.setAluno(aRepository.find(aluno));
			d.setTurma(tRepository.find(turma));
			dRepository.save(d);
			attributes.addFlashAttribute("cadastro", "sucesso");
			

		} catch (Exception e) {

		}
		
		return modelAndView;
	}

}
