package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

//ordenacao (comparable)
public class Usuario implements Serializable, Comparable<Usuario> {
	// java 7
	private static final long serialVersionUID = 1L;
	// implements (Interface) Serializable (serializando para gravar) ..

	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

	private Integer idUsuario;
	private String nome;
	private String email;
	private String perfil;
	private String senha;
	private Date dataCadastro;
	private List<Telefone> telefones;

	public Usuario() {
	}

	public Usuario(Integer idUsuario, String nome, String email, String perfil, String senha, Date dataCadastro) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Usuario) {
			Usuario usu = (Usuario) obj;
			return this.getNome().equals(usu.getNome());
		} else {
			return false;
		}
		
	}

	

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + ", perfil=" + perfil
				+ ", senha=" + senha + ", dataCadastro=" + dataCadastro + ", telefones=" + telefones + "]";
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Compareble e o método compareTo ...
	// compareTo
	@Override
	public int compareTo(Usuario u) {
		return this.idUsuario.compareTo(u.getIdUsuario());//ordem ascendente
		//return u.getIdUsuario().compareTo(this.idUsuario);//ordem descendente
	}
	// o da classe com o de Fora (será ordem Ascendente) ...
	// alt + s gerar get e set
	// alt + s gerar construtores (sobrecarga)
	// alt + s toString

	public static void main(String[] args) {
		// Conceito
		Usuario u1 = new Usuario(100, "lu", "lu@gmail.com", "adm", "123", new Date("06/20/2014"));
		Usuario u2 = new Usuario(101, "marcio", "marcio@gmail.com", "usu", "123", new Date("06/20/2017"));

		Usuario u3 = new Usuario(99, "isabele", "isabele@gmail.com", "usu", "123", new Date("10/25/2018"));

		// Collection<Usuario> lst = new ArrayList<>();
		List<Usuario> lst = new ArrayList<>();
		lst.add(u1);
		lst.add(u2);
		lst.add(u3);
		lst.stream().forEach(System.out::println);
		
		System.out.println("================");
		
		Collections.sort(lst);//Ordena pelo id em ordem crescente
		System.out.println("Em Ordem ....");
		lst.stream().forEach(System.out::println);
		
		Usuario busca = new Usuario();
		busca.setNome("lu");
		
		Usuario resposta = null;
		if (lst.contains(busca)) {
			resposta = lst.get(lst.indexOf(busca));
			
		}
		if (resposta != null) {
			System.out.println("usuario encontrado: "+resposta);
		} else {
			System.out.println("usuario não encontrado");
		}

	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	public void adicionar(Telefone t) {
		if (this.telefones == null) {
			this.telefones = new ArrayList<>();
		}
		this.telefones.add(t);
	}
	
	public void adicionar (Telefone ...t) {
		if (this.telefones == null) {
			this.telefones = new ArrayList<>();
		}
		this.telefones.addAll(Arrays.asList(t));
	}

}
