package br.com.bispo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bispo.model.ComponenteModel;

@Repository
public interface ComponenteRepository extends JpaRepository<ComponenteModel, Long> {

}
