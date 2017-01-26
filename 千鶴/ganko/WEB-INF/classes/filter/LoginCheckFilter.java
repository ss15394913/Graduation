package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogInCheckFilter implements Filter{
	private FilterConfig config;
	
	public void init(FilterConfig config)throws ServletException{
		this.config = config;
	}
	
	public void destroy(){}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	throws ServletException, IOException{
		System.out.println("--LogInCheckFilter--");
		
		HttpSession session = ((HttpServletRequest)req).getSession();
		
		String login = (String)session.getAttribute("login");
		System.out.println("login="+login);
		
		if(login == null || !("OK".equals(login))){ //ñ¢ÉçÉOÉCÉìÇ≈Ç†ÇÈ
			RequestDispatcher dis = req.getRequestDispatcher("/login.jsp");
			session.setAttribute("target", ((HttpServletRequest)req).getRequestURI());
			dis.forward(req, res);
		}else{
			chain.doFilter(req, res);
		}
	}
}