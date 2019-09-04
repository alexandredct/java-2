package br.com.coti.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.coti.entity.Usuario;
import br.com.coti.repository.UsuarioRepository;

@Controller
public class ControllerUsuario {
	ModelAndView mv;

	static Logger logger = LogManager.getLogger(ControllerUsuario.class);

	@Autowired
	private UsuarioRepository dao;

	@RequestMapping(value = "/")
	public ModelAndView init() {
		mv = new ModelAndView("sistema");
		mv.addObject("titulo", "Bem vindo ao Spring Boot");
		mv.addObject("lista", dao.findAll());
		logger.debug("Hello Log4j versao 4 2 ...");
		return mv;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView gravar(Usuario u) {
		mv = new ModelAndView("sistema");
		try {
			if (u.getIdUsuario() != null) {
				mv.addObject("erro", "Não é possível gravar usuário com ID definido");
			}
			dao.save(u);
			logger.info("O usuário  " + u + " foi gravado");
			mv.addObject("resposta", "Dados gravados com sucesso");
		} catch (Exception e) {
			mv.addObject("erro", "Erro na gravação");
		}
		mv.addObject("titulo", "Bem vindo ao Spring Boot");
		mv.addObject("lista", dao.findAll());
		return mv;
	}

	/* com pathVariable */
	@GetMapping(value = "/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		mv = new ModelAndView("sistema");
		try {
			Usuario u = dao.findById(id).get();
			if (u.getIdUsuario() != null) {
				dao.delete(u);
				logger.info("O usuário " + u + " foi removido");
			}
			mv.addObject("resposta", "Usuário " + u.getNome() + " removido com sucesso");
		} catch (Exception e) {
			mv.addObject("erro", "Erro na remoção");
		}
		mv.addObject("titulo", "Bem vindo ao Spring Boot");
		mv.addObject("lista", dao.findAll());
		return mv;
	}

	@PostMapping(value = "/alterar")
	public ModelAndView alterar(Usuario u) {
		mv = new ModelAndView("sistema");
		try {

			if (u.getIdUsuario() != null) {
				dao.save(u);
				logger.info("O usuário " + u + " foi alterado");
			}
			mv.addObject("resposta", "Usuário " + u.getNome() + " atualizado com sucesso.");
		} catch (Exception e) {
			mv.addObject("erro", "Erro na remoção");
		}
		mv.addObject("titulo", "Bem vindo ao Spring Boot");
		mv.addObject("lista", dao.findAll());
		return mv;
	}

}
