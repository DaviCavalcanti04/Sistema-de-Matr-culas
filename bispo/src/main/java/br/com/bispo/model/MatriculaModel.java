package br.com.bispo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "matricula", schema = "escola_db" )
public class MatriculaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula_id")
	private Long matriculaId;	
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private AlunoModel aluno;
	
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private TurmaModel turma;
	
	@Column(name = "data_matricula")
	private Date data_matricula;

	public Long getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Long matriculaId) {
		this.matriculaId = matriculaId;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public TurmaModel getTurma() {
		return turma;
	}

	public void setTurma(TurmaModel turma) {
		this.turma = turma;
	}

	public Date getData_matricula() {
		return data_matricula;
	}

	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}


}