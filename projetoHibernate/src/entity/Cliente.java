package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblcliente")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="cliente_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCliente;
	@Column(length=50)
	private String nome;
	@Column(length=50,unique=true)
	private String email;
	
	@OneToOne(mappedBy="cliente",cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	private Endereco endereco;	
	
	public Cliente() {
		
	}
	public Cliente(Integer idCliente, String nome, String email) {
		
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	
	

}
