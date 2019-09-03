package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cliente_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;

	@Column(length = 50)
	private String nome;
	
	@Column(columnDefinition = "enum('m','f')")
	private String sexo;
	
	@Column
	private String plano;
	
	@Column
	private Double valor;

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", sexo=" + sexo + ", plano=" + plano + ", valor="
				+ valor + "]";
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Long idCliente, String nome, String sexo, String plano, Double valor) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sexo = sexo;
		this.plano = plano;
		this.valor = valor;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
