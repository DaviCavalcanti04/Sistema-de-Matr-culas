package br.com.bispo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bispo.model.MatriculaModel;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {

}
