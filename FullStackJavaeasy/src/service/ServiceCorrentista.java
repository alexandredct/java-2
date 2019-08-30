package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Correntista;
import manager.ManagerCorrentista;

@Path("/correntista")
public class ServiceCorrentista {
	
	@GET
	public String listar() {
		return new Gson().toJson(ManagerCorrentista.correntistas);
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public String gravar (String dados) {
		try {
			Correntista co2 = new Gson().fromJson(dados, Correntista.class);
			ManagerCorrentista.adicionar(co2);
			return new Gson().toJson(co2);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: "+e.getMessage();
		}
		
	}
}
