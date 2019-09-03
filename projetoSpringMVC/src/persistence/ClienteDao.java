package persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Cliente;

public class ClienteDao {
	Session session;
	Transaction transaction;
	Query query;

	public void create(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}

	public void update(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c);
		transaction.commit();
		session.close();
	}

	public void delete(Cliente c) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();
		session.close();
	}

	public Cliente findByCode(Long cod) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = (Cliente) session.get(Cliente.class, cod);
		session.close();
		return cliente;
	}

	public List<Cliente> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Cliente> clientes = session.createQuery("from Cliente").list();
		session.close();
		return clientes;
	}
	
	public Cliente findByEmail(String email) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select c.email from Cliente as c where c.email=:param1");
		query.setParameter(1, email);
		Cliente resp = (Cliente)query.uniqueResult();
		session.close();
		return resp;
	}

}
