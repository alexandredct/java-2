package manager;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Produto;
import service.Consumes;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean {

	private Consumes consumo;
	private Produto produto;
	private List<Produto> produtos;

	public ManagerBean() {
		this.consumo = new Consumes();
	}

	@Override
	public String toString() {
		return "ManagerBean [consumo=" + consumo + ", produto=" + produto + ", produtos=" + produtos + "]";
	}

	public Consumes getConsumo() {
		return consumo;
	}

	public ManagerBean(Consumes consumo, Produto produto, List<Produto> produtos) {
		super();
		this.consumo = consumo;
		this.produto = produto;
		this.produtos = produtos;
	}

	public void setConsumo(Consumes consumo) {
		this.consumo = consumo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		try {
			this.produtos = this.consumo.getProdutos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			this.consumo.gravar(this.produto);
			this.produto = new Produto();
			fc.addMessage(null, new FacesMessage("Dados Gravados"));
		} catch (Exception e) {
			fc.addMessage(null, new FacesMessage("Erro: " + e.getMessage()));
		}
	}

}
