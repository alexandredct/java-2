package persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Aluno;

public class AlunoDao {
	Session session;
	Transaction transaction;
	Query query;

	public void create(Aluno a) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		transaction.commit();
		session.close();
	}

	public List<Aluno> findAll() {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("select obj from Aluno as obj");
		List<Aluno> lista = query.list();
		session.close();
		return lista;
	}

	public static void main(String[] args) {
		try {
			AlunoDao dao = new AlunoDao();
			/* Inserindo novos alunos */
			/*
			 * Aluno a = new Aluno(null, "Thiago 2", "thiaguinho2@gmail.com", "Java", 7.,
			 * 3., "https://randomuser.me/api/portraits/lego/2.jpg"); a.gerar();
			 * dao.create(a); System.out.println("Aluno criado");
			 */

			/* Listar todos */
			System.out.println("Listar todos os alunos");
			// System.out.println(dao.findAll());
			dao.findAll().stream().forEach(System.out::println);

			
			/* Listar os aprovados */
			System.out.println("\n\nListar os alunos aprovados");
			System.out.println(
					dao.findAll().stream().filter(x -> x.getSituacao().equals("Aprovado")).findAny().orElse(null));

			
			/* Listar nome e situação */
			System.out.println("\n\nListar os nome e media dos aprovados");
			List<String> dados = dao.findAll().stream().filter(
					x -> x.getSituacao().equals("Aprovado")
				).map(
					z -> z.getNome() + "," + z.getMedia()
				).collect( Collectors.toList() );
			System.out.println(dados);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
