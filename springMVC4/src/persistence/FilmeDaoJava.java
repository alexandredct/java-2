package persistence;

import entity.Filme;

public class FilmeDaoJava extends FilmeDao {
	
	public Filme findByCode(Integer code) throws Exception{
		Filme resposta = new FilmeDao().findAll().stream().
				filter(x -> x.getIdFilme().equals(code)).findAny().orElse(null);
		return resposta;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
