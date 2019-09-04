package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	AlunoRepository dao_aluno;

	@Autowired
	DisciplinaRepository dao_disciplina;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		Aluno a = new Aluno(null, "alexandre");
		dao_aluno.save(a);
		System.out.println("Gravado o aluno: " + a);

		Disciplina d = new Disciplina(null, "Disciplina 1");
		dao_disciplina.save(d);
		System.out.println("Gravada a disciplina: " + d);

		Disciplina d2 = new Disciplina(null, "angular");
		d2.setAluno(a);
		dao_disciplina.save(d2);
		System.out.println("Testa e Roda ...");

		System.out.println(dao_aluno.findAll());
		System.out.println(dao_disciplina.findAll());

	}
}
