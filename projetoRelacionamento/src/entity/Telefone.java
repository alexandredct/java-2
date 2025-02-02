package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_telefone")
public class Telefone implements Serializable{
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@Column(name="telefone_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTelefone;
	
	@Column(length=40)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente_id", referencedColumnName="cliente_id")
	private Cliente cliente;
	
	
	
	
	
	
	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Telefone(Integer idTelefone, String numero, Cliente cliente) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(Integer idTelefone, String numero) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + "]";
	}
	
	
	
	
}
