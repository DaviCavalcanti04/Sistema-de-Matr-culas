package br.com.bispo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "aluno", schema = "escola_db" )
public class AlunoModel {
	
	@Id
	@Column(name = "aluno_id")
	private Long alunoId;	
	
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@Column(name = "CPF")
	private Date CPF;
	
	@Column(name = "nascimento")
	private Date nascimento;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone")
	private Long telefone;
	
}