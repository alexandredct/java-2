package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filtro
 */
@WebFilter({"/adm/*","/usu/*"})
public class Filtro implements Filter {

    /**
     * Default constructor. 
     */
    public Filtro() {
    
    }
    
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Faz a conversão para coletar recursos de URL do Servlet
		HttpServletRequest req = (HttpServletRequest) request;	
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		//Checa se existe a sessão
		if(session.getAttribute("usuario") != null) {
			chain.doFilter(request, response);
		}else {
			req.setAttribute("msg", "Não é possivel navegar na URL");
			req.getRequestDispatcher("../error.jsp").forward(req,resp);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

		
	}

}
