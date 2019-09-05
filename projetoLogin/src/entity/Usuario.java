package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="usuario_id")
	@GeneratedValue
	private Long idUsuario;
	private String login;
	private String senha;
	private String perfil;
	
	@OneToOne(mappedBy="usuario",
			fetch=FetchType.EAGER,
			cascade= {CascadeType.ALL}
			)
	private Aluno aluno;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil
				+ ", aluno=" + aluno + "]";
	}

	public Usuario(Long idUsuario, String login, String senha, String perfil, Aluno aluno) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.aluno = aluno;
	}
	
	
	
}
