package adapter;

import org.bson.Document;

import entity.Produto;

public class ProdutoAdapter {

	public static Document toDocument(Produto p) {
		Document doc = new Document();
		doc.append("idProduto", p.getIdProduto());
		doc.append("nomeFilme", p.getNomeFilme());
		doc.append("precoAluguel", p.getPrecoAluguel());
		doc.append("imagem", p.getImagem());
		return doc;
	}
	
	public static Produto toProduto (Document doc) {
		Produto p = new Produto(
				doc.getDouble("idProduto"), 
				doc.getString("nomeFilme"), 
				doc.getDouble("precoAluguel"),
				doc.getString("imagem")
				);
		return p;
	}
}

