package br.com.bispo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "matricula", schema = "escola_db" )
public class MatriculaModel {

	@Column(name = "curso_id")
	private Long cursoId;	
	
	@Column(name = "nome_curso")
	private String nomeCurso;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "carga_horaria")
	private Float cargaHoraria;
	
}