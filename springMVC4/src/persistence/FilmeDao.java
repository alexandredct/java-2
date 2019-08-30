package persistence;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import entity.Filme;

public class FilmeDao extends Dao {

	public Integer create(Filme f) throws Exception {
		open();
		call = con.prepareCall("{?= call gravarFilme(?,?,?,?,?)}");
		call.registerOutParameter(1, Types.INTEGER);
		call.setString(2, f.getNomeFilme());
		call.setDouble(3, f.getPreco());
		call.setString(4, f.getCategoria());
		call.setString(5, f.getImagem());
		call.setString(6, f.getTrailer());
		call.execute();
		int chave = call.getInt(1);
		close();
		return chave;
	}
	
	public List<Filme> findAll() throws Exception{
		open();
		List<Filme> resposta = new ArrayList<>();
		stmt = con.prepareStatement("select * from filme");
		rs = stmt.executeQuery();
		while(rs.next()) {
			Filme f= new Filme(
					rs.getInt(1),
					rs.getString(2),
					rs.getDouble(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
			);
			resposta.add(f);
		}
		close();
		return resposta;
	}
	
	public static void main(String[] args) {
		try {
			FilmeDao dao = new FilmeDao();
			Filme f = new Filme(null,"Filme de teste", 18.,"ação","image.png","tailer.mov");
			//Integer resposta = dao.create(f);
			//System.out.println(resposta == 1 ? "Gravado com sucesso" : "Já existe");
			
			System.out.println("================");
			
			System.out.println(dao.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
