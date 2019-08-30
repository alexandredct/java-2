package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbldisciplina")
@SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "disciplina_id")
	@Id
	@GeneratedValue(generator = "seq_disciplina")
	private Integer idDisciplina;
	@Column(length = 50)
	private String nomeDisciplina;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "disciplinaaluno", joinColumns = @JoinColumn(name = "disciplina_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> alunos;

	// gravacao da tabela é feito pelo mais fraco
	// a tabela será construída

	public Disciplina() {

	}

	public Disciplina(Integer idDisciplina, String nomeDisciplina) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
	}

	public Disciplina(Integer idDisciplina, String nomeDisciplina, List<Aluno> alunos) {
		super();
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", alunos=" + alunos
				+ "]";
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
