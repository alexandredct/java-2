package service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Produto;
import manager.ManagerProduto;

@Path("/produto")
public class ServiceProduto {
	@GET
	public String listar( ) {
		return new Gson().toJson(ManagerProduto.lista);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String gravar (String produto) {
		try {
			Produto prod = new Gson().fromJson(produto, Produto.class);
			ManagerProduto.adicionar(prod);
			return new Gson().toJson(prod);
		} catch (Exception e) {
			Map <String,String> error = new HashMap<String, String> ();
			error.put("error", e.getMessage());
			return new Gson().toJson(error);
		}
		
		
	}
}
