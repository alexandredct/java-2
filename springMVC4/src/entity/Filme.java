package entity;

import java.io.Serializable;

public class Filme implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idFilme;
	private String nomeFilme;
	private Double preco;
	private String categoria;
	private String imagem;
	private String trailer;
	
	public Filme() {
		// TODO Auto-generated constructor stub
	}

	public Filme(Integer idFilme, String nomeFilme, Double preco, String categoria, String imagem, String trailer) {
		super();
		this.idFilme = idFilme;
		this.nomeFilme = nomeFilme;
		this.preco = preco;
		this.categoria = categoria;
		this.imagem = imagem;
		this.trailer = trailer;
	}

	public Integer getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Integer idFilme) {
		this.idFilme = idFilme;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		categoria = categoria;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Filme [idFilme=" + idFilme + ", nomeFilme=" + nomeFilme + ", preco=" + preco + ", Categoria="
				+ categoria + ", imagem=" + imagem + ", trailer=" + trailer + "]";
	}
	
	

}
