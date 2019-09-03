package persistence;

import java.util.List;

import org.hibernate.Session;

import entity.Cliente;

public class ClienteDao {
	
	Session session;
	
	public List<Cliente> findAll(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> lista = session.createQuery("from Cliente").list();
		session.close();
		return lista;
	}

}
