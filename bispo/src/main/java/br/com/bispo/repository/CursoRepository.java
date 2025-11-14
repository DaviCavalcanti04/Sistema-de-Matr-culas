package br.com.bispo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bispo.model.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

}
