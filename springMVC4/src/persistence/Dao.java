package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	CallableStatement call;

	public void open() throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		;
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "oialuno", "coti");
	}
	
	public void close() throws Exception{
		con.close();
	}
}
