package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblaluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "aluno_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer idAluno;

	private String nome;

	@Column(length = 50, unique = true)
	private String email;

	private String disciplina;

	private Double nota1;

	private Double nota2;

	private Double media;

	private String situacao;

	private String foto;

	public Aluno() {

	}

	public Aluno(Integer idAluno, String nome, String email, String disciplina, Double nota1, Double nota2,
			String foto) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.email = email;
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", email=" + email + ", disciplina=" + disciplina
				+ ", nota1=" + nota1 + ", nota2=" + nota2 + ", media=" + media + ", situacao=" + situacao + ", foto="
				+ foto + "]";
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void gerar() {
		this.media = (this.nota1 + this.nota2) / 2;
		if (this.media >= 7) {
			this.situacao = "Aprovado";
		} else {
			this.situacao = "Reprovado";
		}
	}

}
