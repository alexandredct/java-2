package main;

import java.util.Date;

import entity.Telefone;
import entity.Usuario;

public class Main {
	public static void main(String[] args) {
		Usuario u = new Usuario(100, "Lu", "lu@teste.com", "usu", "123", new Date());
		Telefone t1 = new Telefone(100, "219898989898");
		Telefone t2 = new Telefone(101, "21999999999");
		u.adicionar(t1, t2);
		
		System.out.println("=====================");
		System.out.println(u);
		System.out.println("=====================");
		System.out.println(t1);
		System.out.println("=====================");
		System.out.println(t2);
	}
}
