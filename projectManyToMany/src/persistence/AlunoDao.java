package persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Aluno;
import entity.Disciplina;

public class AlunoDao {

	Session session;
	Transaction transaction;
	Query query;

	public void create(Aluno a, Disciplina d) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(a);
		d.adicionarAluno(a);
		session.save(d);
		transaction.commit();
	}

	public void alocarAlunoTurma(Aluno a, Disciplina d) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		Aluno resp = (Aluno) session.get(Aluno.class, a.getIdAluno());
		
		if (resp == null) {
			a.setIdAluno(null);
			session.save(a);
			d.adicionarAluno(a);
		} else {
			d.adicionarAluno(resp);
		}
		session.save(d);
		transaction.commit();
		session.close();
	}

//	public Aluno buscarCodigo(Integer cod) {
//		session = HibernateUtil.getSessionFactory().openSession();
//
//		Aluno resp = (Aluno) session.get(Aluno.class, cod);
//		session.close();
//		return resp;
//	}

	public static void main(String[] args) {
		try {
			Aluno a1 = new Aluno(1, "manu", "manu@gmail.com");
			Aluno a2 = new Aluno(null, "lu", "lu@gmail.com");

			Disciplina d1 = new Disciplina(null, "java");
			Disciplina d2 = new Disciplina(null, "angular");
			Disciplina d3 = new Disciplina(null, "ionic");

			AlunoDao dao = new AlunoDao();
//			dao.create(a1, d2);
			dao.alocarAlunoTurma(a1, d3);
			System.out.println("Dados gravados");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
