package afpa.Servlet;

import java.io.IOException;
import java.sql.SQLException;

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

import afpa.DAO.UserDao;

/**
 * Servlet Filter implementation class LawFilter
 */
@WebFilter(filterName = "admin", urlPatterns = "/admin/*")
public class LawFilter implements Filter {
	UserDao adminUserDao;
    /**
     * Default constructor. 
     */
    public LawFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		HttpSession session = httpServletRequest.getSession();
//		servletRequest.setCharacterEncoding("UTF-8");
		String login = null;
		login = (String) session.getAttribute("login");
		String password = null;
		password = (String) session.getAttribute("password");
		adminUserDao = new UserDao();
		try {
			if ( adminUserDao.law(login, password) != null ) {
				session.setAttribute("admin", "true");
			} else {	  
				session.setAttribute("admin", "false");					
			}
					// pass the request along the filter chain
				filterChain.doFilter(httpServletRequest, httpServletResponse);
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}					

	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
