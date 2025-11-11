package br.com.bispo.model;

	import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table (name = "turma", schema = "escola_db" )
	public class TurmaModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "turma_id")
		private Long turmaId;	
		
		@Column(name = "componente_id")
		private String componenteId;
		
		@Column(name = "ano_semestre")
		private Long anoSemestre;
		
		@Column(name = "capacidade")
		private Long capacidade;
		
		@Column(name = "curso_id")
		private Long cursoId;

		public Long getTurmaId() {
			return turmaId;
		}

		public void setTurmaId(Long turmaId) {
			this.turmaId = turmaId;
		}

		public String getComponenteId() {
			return componenteId;
		}

		public void setComponenteId(String componenteId) {
			this.componenteId = componenteId;
		}

		public Long getAnoSemestre() {
			return anoSemestre;
		}

		public void setAnoSemestre(Long anoSemestre) {
			this.anoSemestre = anoSemestre;
		}

		public Long getCapacidade() {
			return capacidade;
		}

		public void setCapacidade(Long capacidade) {
			this.capacidade = capacidade;
		}

		public Long getCursoId() {
			return cursoId;
		}

		public void setCursoId(Long cursoId) {
			this.cursoId = cursoId;
		}

		
}