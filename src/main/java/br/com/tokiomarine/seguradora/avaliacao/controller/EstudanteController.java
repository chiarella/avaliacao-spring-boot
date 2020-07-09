package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	// TODO efetue a correção dos problemas que existem na classe Estudante

	@Autowired
	EstudandeService service;

	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("/listar")
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}

	@PostMapping(path = "/add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {

		if (result.hasErrors() || result.toString().trim().equals("")) {

			return "cadastrar-estudante";
		}

		service.cadastrarEstudante(estudante);

		return "redirect:listar";
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {

		Optional<Estudante> estudante = service.getEstById(id);
		ModelAndView modelAndView = new ModelAndView("atualizar-estudante");
		modelAndView.addObject("estudante", estudante.get());
		return modelAndView;

	}

	@PostMapping("/atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") Long id, @Valid Estudante estudante, BindingResult result,
			Model model) {

		if (result.hasErrors() || result.toString().trim().equals("")) {
			return "atualizar-estudante";
		}

		service.atualizarEstudante(id, estudante);
		model.addAttribute("estudantes", service.buscarEstudantes());

		return "index";
	}

	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") Long id, Model model) {
		service.deleteById(id);
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}

}
