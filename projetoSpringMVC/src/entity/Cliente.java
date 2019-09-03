package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="cliente_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=50)
	private String nome;
	@Column(length=50, unique=true)
	private String email;
	@Column(length=20)
	private String cep;
	@Column(length=35)
	private String logradouro;
	@Column(length=35)
	private String bairro;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long id, String nome, String email, String cep, String logradouro, String bairro) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", cep=" + cep + ", logradouro="
				+ logradouro + ", bairro=" + bairro + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
