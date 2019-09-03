package main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tbl_produto")
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="produto_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/* primary key deve ser LONG */
	private Long idProduto;
	
	@Column(length=50)
	@Size(min=2, max=50, message="Faixa de validação do nome")
	private String nome;
	
	@Column
	private Double preco;
		
	private Integer quantidade;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+ "]";
	}

	public Produto(Long idProduto, @Size(min = 2, max = 50, message = "Faixa de validação do nome") String nome,
			Double preco, Integer quantidade) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
