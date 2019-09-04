package main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_disciplina")

public class Disciplina implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="disciplina_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDisciplina;
	
	@Column
	private String nomeDisciplina;
	
	@ManyToOne
	@JoinColumn(name="fk_aluno_id", referencedColumnName = "aluno_id")
	private Aluno aluno;
	
	public Disciplina() {
	
	}

	public Disciplina(Long idDisciplina, String nomeDisciplina, Aluno aluno) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.aluno = aluno;
	}
	
	public Disciplina(Long idDisciplina, String nomeDisciplina) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", aluno=" + aluno
				+ "]";
	}

	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
	
	
	
	
}
