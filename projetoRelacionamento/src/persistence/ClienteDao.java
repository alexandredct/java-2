package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Cliente;
import entity.Telefone;

public class ClienteDao {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("UPRelaciona");
	
	static EntityManager em;
	EntityTransaction transaction;
	
	static {
		if (em == null) {
			em=factory.createEntityManager();
		}
	}
	
	public void createClienteTelefone (Cliente c, List <Telefone> telefones ){
		transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		for (Telefone t : telefones) {
			t.setCliente(c);
			em.persist(t);
		}
		transaction.commit();
	}
	
	public void createCliente (Cliente c){
		transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		
		for (Telefone t : c.getTelefones()) {
			if (t.getCliente() == null) {
				t.setCliente(c);
			}
			em.persist(t);
		}
		transaction.commit();
		
		
	}
	
	public static void main(String[] args) {
		Cliente c = new Cliente(null, "lu", "lu@gmail.com");
		Telefone t[] = new Telefone[] {
				new Telefone (null, "22222222"),
				new Telefone (null, "33333333"),
				new Telefone (null, "44444444")
		};
		c.adicionarTelefone(t);
		
		try {
			ClienteDao dao = new ClienteDao();
			dao.createCliente(c);
			System.out.println("Dados gravados");
		} catch (Exception e) {
			System.err.println("Error: "+e.getMessage());
			e.printStackTrace();
		}
	}
}


