package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

// TODO não esquecer de usar as anotações para criação do restcontroller

@RestController
@RequestMapping("/estudante2/")
public class EstudanteRestController {

	@Autowired
	EstudandeService service;

	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em
	// forma de RESTCONTROLLER (seguindo o padrão RESTFUL)

	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)

	@PostMapping(value = "/save")
	public void save(@RequestBody Estudante estudante) {
		service.cadastrarEstudante(estudante);

	}

	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)

	@PutMapping(value = "/edit/{id}")
	public Estudante updateEstudante(@PathVariable("id") Long id, @RequestBody Estudante estudante) {
		return service.updateEstudante(id, estudante);
	}

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)

	@GetMapping(value = "/findAll")
	public List<Estudante> findAll() {
		return service.buscarEstudantes();
	}

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}
