package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

@Service
@Transactional
public interface EstudandeService {

	List<Estudante> buscarEstudantes();

	void cadastrarEstudante(@Valid Estudante estudante);

	Estudante buscarEstudanteById(Long id);

	Estudante deleteById(Long id);

	Estudante updateEstudante(Long id, Estudante estudante);

	void atualizarEstudante(@Valid Long id, Estudante estudante);

	Estudante update(Estudante estudante);
		
	Optional<Estudante> getEstById(Long id);

	List<Estudante> getAll();
}
