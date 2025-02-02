package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tblaluno")
@SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "aluno_id")
	@Id
	@GeneratedValue(generator = "seq_aluno")
	private Integer idAluno;
	@Column(length = 50)
	private String nome;
	@Column(length = 50, unique = true)
	private String email;

	@ManyToMany(mappedBy = "alunos") // está mapeando nao gera tabela
	// dele irá aparecer
	private List<Disciplina> disciplinas;

	public Aluno() {
	}

	public Aluno(Integer idAluno, String nome, String email) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + "]";
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void adicionarDisciplina(Disciplina d) {
		if (this.disciplinas == null) {
			this.disciplinas = new ArrayList<Disciplina>();
		}
		this.disciplinas.add(d);
	}

	// se esse é o primeiro
	// mais forte
	// Se eu Mapear pelo Aluno, a tabela relacional
	// fica feita por disciplina ...

}
