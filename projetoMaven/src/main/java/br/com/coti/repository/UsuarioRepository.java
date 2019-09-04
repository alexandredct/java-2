package br.com.coti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.coti.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
