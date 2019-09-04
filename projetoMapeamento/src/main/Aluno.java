package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="aluno_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAluno;
	
	@Column(length=50)
	private String nome;
	
	@OneToMany(mappedBy="aluno", cascade = { CascadeType.ALL})
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return idAluno;
	}

	public void setId(Long id) {
		this.idAluno = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", disciplinas=" + disciplinas + "]";
	}

	public Aluno(Long id, String nome) {
		super();
		this.idAluno = id;
		this.nome = nome;
	}
	
	
	public void adicionar (Disciplina d) {
		if (disciplinas == null) {
			this.disciplinas = new ArrayList<Disciplina>();
		}
		this.disciplinas.add(d);
	}
}
