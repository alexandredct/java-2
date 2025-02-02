package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto implements Serializable {

	private Double idProduto;
	private String nomeFilme;
	private Double precoAluguel;
	private String imagem;

	public Produto(Double idProduto, String nomeFilme, Double precoAluguel, String imagem) {
		super();
		this.idProduto = idProduto;
		this.nomeFilme = nomeFilme;
		this.precoAluguel = precoAluguel;
		this.imagem = imagem;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Double getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Double idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public Double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(Double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeFilme=" + nomeFilme + ", precoAluguel=" + precoAluguel
				+ ", imagem=" + imagem + "]";
	}

}
