package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Cliente;
import persistence.ClienteDao;

@Controller
public class ControllerCliente {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView init() {
		/* Ao iniciar a lista e as mensagens vão para o sistema */
		ModelAndView mv = new ModelAndView("sistema");
		mv.addObject("lista", new ClienteDao().findAll());
		mv.addObject("msgum", "Bem vindo ao Spring MVC");
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/cadastrar.html", method = RequestMethod.POST)
	public ModelAndView gravar(Cliente c) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			ClienteDao dao = new ClienteDao();
			dao.create(c);
			mv.addObject("lista", new ClienteDao().findAll() );
			mv.addObject("msg", "Dados gravados");
		} catch (Exception e) {
			mv.addObject("msg", "error: " + e.getMessage());
		}
		
		
		return mv;
	}
	
	@RequestMapping(value = "/excluir.html/{id}", method = RequestMethod.GET)
	public ModelAndView excluir(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			ClienteDao dao = new ClienteDao();
			Cliente cliente = dao.findByCode(new Long (id) );
			dao.delete(cliente);
			mv.addObject("lista", new ClienteDao().findAll() );
			mv.addObject("msg", "Dados gravados");
		} catch (Exception e) {
			mv.addObject("msg", "error: " + e.getMessage());
		}
		
		
		return mv;
	}
	
	@RequestMapping(value = "/alterar.html", method = RequestMethod.POST)
	public ModelAndView alterar(Cliente cliente) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			ClienteDao dao = new ClienteDao();
			dao.update(cliente);
			mv.addObject("lista", new ClienteDao().findAll() );
			mv.addObject("msg", "Dados alterados com sucesso");
		} catch (Exception e) {
			mv.addObject("msg", "error: " + e.getMessage());
		}
		return mv;
	}

}
