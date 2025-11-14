package br.com.bispo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bispo.model.TurmaModel;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaModel, Long> {

}
