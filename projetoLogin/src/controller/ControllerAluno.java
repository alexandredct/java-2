package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import entity.Aluno;
import persistence.AlunoDao;

@Controller
public class ControllerAluno {
	ModelAndView mv;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView init() {
		 mv = new ModelAndView("sistema");
		 mv.addObject("msg", "");
		 mv.addObject("alunos", new AlunoDao().findAll());
		 return mv;
	}
	
	@RequestMapping(value="/listagem", method=RequestMethod.GET)
	public String listar() {
		 return new Gson().toJson(new AlunoDao().findAll());
	}
	
	@RequestMapping(value="/gravar", method=RequestMethod.POST)
	public ModelAndView gravar (Aluno a) {
		mv = new ModelAndView("sistema");
		try {
			a.setMedia(0.);
			a.setSituacao("");
			a.gerar();
			new AlunoDao().create(a);
			mv.addObject("msg", "Dados gravados");
			mv.addObject("alunos", new AlunoDao().findAll());
		} catch (Exception e) {
			mv.addObject("erro", "Falha na gravação: "+e.getMessage());
			e.printStackTrace();
		}
		return mv;
		
		
	}
}

