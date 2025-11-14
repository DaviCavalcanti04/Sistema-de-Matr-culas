package br.com.bispo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bispo.model.AlunoModel;
import br.com.bispo.model.MatriculaModel;
import br.com.bispo.model.TurmaModel;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
	List<MatriculaModel> findByAluno(AlunoModel aluno);
	Optional<MatriculaModel> findByAlunoAndTurma(AlunoModel aluno, TurmaModel turma);


}
