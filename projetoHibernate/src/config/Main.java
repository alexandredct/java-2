package config;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration().configure("config/mysql_hibernate.cfg.xml");
		new SchemaExport(conf).create(true,true);
		System.out.println("Tabela criada com sucesso");
	}
}
