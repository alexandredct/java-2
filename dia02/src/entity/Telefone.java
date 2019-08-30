package entity;

import java.io.Serializable;

public class Telefone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private Integer idTelefone;
	private String numero;
	
	private Usuario	usuario;
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}

	public Telefone(Integer idTelefone, String numero) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
	}

	public Telefone(Integer idTelefone, String numero, Usuario usuario) {
		super();
		this.idTelefone = idTelefone;
		this.numero = numero;
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Telefone [idTelefone=" + idTelefone + ", numero=" + numero + ", usuario=" + usuario + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
