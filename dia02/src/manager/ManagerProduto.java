package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Produto;

public class ManagerProduto {
	
	public static List<Produto> lista = new ArrayList<>();
	
	static {
		lista.add(new Produto(100., "Shazzan", 12., 
				"http://br.web.img3.acsta.net/c_215_290/pictures/19/02/21/21/08/3735597.jpg"));
		lista.add(new Produto(101., "Vingadores", 20., 
				"https://www.hojeemdia.com.br/polopoly_fs/1.708537.1555629319!/image/image.jpg_gen/derivatives/landscape_653/image.jpg"));
		lista.add(new Produto(102., "a mula",15.,
				   "https://static.cineclick.com.br/sites/adm/uploads/banco_imagens/77/1260x530_1554998019.jpg"));
		
	}
	
	public static void adicionar(Produto p) {
		lista.add(p);
	}
	
	public static void ordernarNome () {
		Comparator <Produto> comp = new Comparator<Produto> () {
			@Override
			public int compare (Produto p1, Produto p2) {
				return p1.getNomeFilme().compareTo(p2.getNomeFilme());
			}
		};
		Collections.sort(lista, comp);
	}
	
	public static void ordernarId() {
		Comparator <Produto> comp = new Comparator<Produto> () {
			@Override
			public int compare (Produto p1, Produto p2) {
				return p1.getIdProduto().compareTo(p2.getIdProduto());
			}
		};
		Collections.sort(lista, comp);
	}
	
	public static void ordernarPreco() {
		Comparator <Produto> comp = new Comparator<Produto> () {
			@Override
			public int compare (Produto p1, Produto p2) {
				return p1.getPrecoAluguel().compareTo(p2.getPrecoAluguel());
			}
		};
		Collections.sort(lista, comp);
	}
	
	public static void main(String[] args) {
		lista.stream().forEach(System.out::println);
		System.out.println("====================================");
		
		ManagerProduto.adicionar(new Produto(98., "Homem aranha",20.2,null));
		
		
		
		ManagerProduto.ordernarNome();
		
		lista.stream().forEach(System.out::println);
		
	}

}
