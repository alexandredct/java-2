package main;

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
public class Aluno {
	@Id
	@Column(name="aluno_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=50)
	private String nome;
	
	@OneToMany(mappedBy="aluno", cascade = { CascadeType.ALL})
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "Aluno [id=" + id + ", nome=" + nome + ", disciplinas=" + disciplinas + "]";
	}

	public Aluno(Integer id, String nome, List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.nome = nome;
		this.disciplinas = disciplinas;
	}
}
