package entity;

import java.io.Serializable;

public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Long idAluno;
	private String nome;
	private String disciplina;
	private Double nota1;
	private Double nota2;
	private Double media=0.;
	private String situacao;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Aluno [idAluno=" + idAluno + ", nome=" + nome + ", disciplina=" + disciplina + ", nota1=" + nota1
				+ ", nota2=" + nota2 + ", media=" + media + ", situacao=" + situacao + "]";
	}

	public Aluno(Long idAluno, String nome, String disciplina, Double nota1, Double nota2) {
		super();
		this.idAluno = idAluno;
		this.nome = nome;
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
