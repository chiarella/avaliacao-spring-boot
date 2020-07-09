package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

// TODO Efetue a implementação dos métodos da classe service
@Service
@Transactional
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	private EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Long id, Estudante estudante) {
		estudante.setId(id);
		repository.save(estudante);

	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return repository.findAll();
	}

	@Override
	public Estudante buscarEstudanteById(Long id) {

	// throw new IllegalArgumentException("Identificador inválido:" + id);
	
		return null;
	}

	@Override
	public Estudante deleteById(Long id) {
		repository.deleteById(id);
		return null;
	}

	// @Override
	public Estudante updateEstudante(Long id, Estudante estudante) {
		estudante.setId(id);
		return repository.save(estudante);
	}

	public Estudante update(Estudante estudante) {
		return repository.save(estudante);
	}

	public Optional<Estudante> getEstById(Long id) {
		return repository.findById(id);
	}

	public List<Estudante> getAll() {

		return (List<Estudante>) repository.findAll();
	}

}
