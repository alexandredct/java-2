package persistence;

import entity.Usuario;

public class UsuarioDao extends DaoMysql {
	public Usuario findByLogin(Usuario u) throws Exception {
		open();
		stmt = con.prepareStatement("select * from usuario where email = ? and senha = md5(?)");
		stmt.setString(1, u.getEmail());
		stmt.setString(2, u.getSenha());
		rs = stmt.executeQuery();
		Usuario resp = null;
		if (rs.next()) {
			resp = new Usuario(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(4), 
					rs.getString(5), 
					rs.getDate(6)
			);
		}
		close();
		return resp;
	}
}
