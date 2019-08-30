package manager;

import java.util.ArrayList;
import java.util.List;

import entity.Correntista;

public class ManagerCorrentista {

	public static List<Correntista> correntistas= new ArrayList<Correntista>();
	
	static {
		correntistas.add(new Correntista(1000, "lu", "lu@gmail.com", 2000.));
		correntistas.add(new Correntista(2000, "robo", "robo@gmail.com", 1000.));
		correntistas.add(new Correntista(3000, "bus", "bus@gmail.com", 4000.));
	}
	
	 public static void adicionar(Correntista co) {
		    correntistas.add(co);
	 }
	 
	//service (PONTE) _ Java (REST)  Angular
	 //ServiceCorrentista
	 //web.xml, libs, Configurar a Classe botar no Ar,
	 //Abrir CorsFilter ....
	 
	 
	 
	 
	 
	

	
}
