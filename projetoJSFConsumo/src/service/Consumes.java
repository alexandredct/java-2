package service;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import entity.Produto;

public class Consumes {
	
	Client client;
	WebResource webresource;
	ClientResponse response;
	
	public List<Produto> getProdutos (){
		
		try {
			client = Client.create();
			webresource = client.resource("http://localhost:4499/produto");
			response = webresource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new Exception("Falha ao carregar");
			}
			String saida = response.getEntity(String.class);
			List<Produto> lista = new Gson().fromJson(
					saida,
					new TypeToken <List<Produto>>() {}.getType()
					);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void gravar (Produto p) throws Exception{
		client = Client.create();
		webresource = client.resource("http://localhost:4499/produto");
		webresource.type("application/json").
			accept("application/json").
			post( new Gson().toJson(p));
	}
	
	public static void main(String[] args) {
		System.out.println("Antes:");
		System.out.println(new Consumes().getProdutos());
		
		
		System.out.println("====================\nDepois:");
		Produto p = new Produto(null, "Teste de filme 3", 25.4, 4);
		try {
			new Consumes().gravar(p);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		System.out.println(new Consumes().getProdutos());
	}

}
