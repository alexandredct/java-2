package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Filme;
import persistence.FilmeDao;

@Controller
public class ControllerFilme {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView iniciar() {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			FilmeDao dao = new FilmeDao();
			System.out.println(dao.findAll());
			mv.addObject("msg","Bem vindo ao Spring MVC");
			mv.addObject("filmes", dao.findAll());
			
		} catch (Exception e) {
			mv.addObject("erro","error: "+e.getMessage());
		}
		return mv;
	}
	
	
	
	
	@RequestMapping(value="/cadastro.html", method=RequestMethod.POST)
	public ModelAndView gravar(Filme f) {
		ModelAndView mv = new ModelAndView("sistema");
		try {
			mv.addObject("msg","Bem vindo ao Spring MVC");
			FilmeDao dao = new FilmeDao();
			int resposta = dao.create(f);
			if (resposta == 1) {
				mv.addObject("resposta","Dados gravados com Xuxean ...<br>" + f);
			} else {
				mv.addObject("resposta","Falha na gravação...");
			}
			mv.addObject("filmes", dao.findAll());
			
		} catch (Exception e) {
			mv.addObject("erro","error: "+e.getMessage());
		}
		return mv;
	}
}
