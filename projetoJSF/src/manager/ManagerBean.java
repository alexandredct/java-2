package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Aluno;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean {

	private Aluno aluno;
	private List<Aluno> alunos;

	public ManagerBean() {
		this.aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Aluno> getAlunos() {
		if (this.alunos == null) {
			this.alunos = new ArrayList<Aluno>();

		}
		return alunos;
	}

	public void adicionar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.alunos.add(this.aluno);
		fc.addMessage(null, new FacesMessage("Adicionado " + this.aluno));
		this.aluno = new Aluno();
	}

	public void calcularMedia() {
		this.aluno.setMedia((this.aluno.getNota1() + this.aluno.getNota2()) / 2);
		this.aluno.setSituacao((this.aluno.getMedia() >= 7) ? "aprovado" : "reprovado");
	}

}
