package br.com.bispo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "matricula", schema = "escola_db" )
public class MatriculaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula_id")
	private Long matriculaId;	
	
	@Column(name = "aluno_id")
	private String alunoId;
	
	@Column(name = "turma_id")
	private Long turmaId;
	
	@Column(name = "data_matricula")
	private Date data_matricula;

	public Long getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Long matriculaId) {
		this.matriculaId = matriculaId;
	}

	public String getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(String alunoId) {
		this.alunoId = alunoId;
	}

	public Long getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

	public Date getData_matricula() {
		return data_matricula;
	}

	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}

	
}