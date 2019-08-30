package entity;

import java.io.Serializable;
 

public class Correntista  implements Serializable{

	private static final long serialVersionUID = 1L;

	 private Integer idCorrentista;
	 private String nome;
	 private String email;
	 private Double saldo=0.;
	  private String operacao;
	 private Double valor=0.;
 
 
	 
	 public Correntista() {
	}
	

	public Correntista(Integer idCorrentista, String nome, String email, Double saldo) {
		this.idCorrentista = idCorrentista;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
	}

	

	
	public Correntista(Integer idCorrentista, String nome, String email, Double saldo, String operacao, Double valor) {
		super();
		this.idCorrentista = idCorrentista;
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		this.operacao = operacao;
		this.valor = valor;
	}


	@Override
	public String toString() {
		return "Correntista [idCorrentista=" + idCorrentista + ", nome=" + nome + ", email=" + email + ", saldo="
				+ saldo + ", operacao=" + operacao + ", valor=" + valor + "]";
	}


	public Integer getIdCorrentista() {
		return idCorrentista;
	}
	public void setIdCorrentista(Integer idCorrentista) {
		this.idCorrentista = idCorrentista;
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
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	public String getOperacao() {
		return operacao;
	}


	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}

/*
	public List<Correntista> getHistorico() {
		return historico;
	}


	public void setHistorico(List<Correntista> historico) {
		this.historico = historico;
	}
*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
/*	
	aqui está a Lógica ...
	public void adicionarHistorico(Correntista c) {
		 if (this.historico==null) {
		   this.historico = new ArrayList<Correntista>();
		 }
		 
		 if (this.getOperacao().equals("deposito")) {
		      this.setSaldo(this.getSaldo() + this.valor);
		 } else if (this.getOperacao().equals("retirada")) {
			      this.setSaldo(this.getSaldo() - this.valor);
    	 }
    	 		 this.historico.add( 
				 new Correntista(c.getIdCorrentista(),c.getNome(),c.getEmail(),
	        		       c.getSaldo(),	  this.getOperacao(), this.getValor())
				 );
	}*/
		
	
	

	 
	 
		
	
	
	
	 
	
}
