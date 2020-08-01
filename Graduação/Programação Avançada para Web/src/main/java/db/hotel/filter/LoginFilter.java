package db.hotel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

    public LoginFilter() { }

	public void destroy() { }
	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response; 
		//HttpSession sess = req.getSession(false);
		String uri = req.getRequestURI();

        if (uri.contains(".js") ||
        	uri.contains(".css") ||
        	uri.contains(".svg") ||
        	uri.contains(".gif") ||
        	uri.contains(".png")) {
        	resp.setHeader("Cache-Control", "max-age=2592000");
        	resp.setDateHeader("Expires", System.currentTimeMillis() + 2592000000L); // Proxies.
        } else {
	        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			resp.setDateHeader("Expires", -1); // Proxies.
        }

        
        /*if (sess == null || sess.getAttribute("usuario") == null) {
        	if(req.getRequestURI().equals(req.getContextPath() + "/"))
        		chain.doFilter(req, resp);	
        	else
        		resp.sendRedirect(req.getContextPath());
        } else {
            chain.doFilter(req, resp);
        }*/
        
        chain.doFilter(req, resp);
	}
}