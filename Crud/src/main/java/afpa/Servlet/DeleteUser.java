package afpa.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import afpa.Beans.User;
import afpa.DAO.UserDao;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet(name="DleteUser", urlPatterns="/admin/delUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		if ( session.getAttribute("admin") == "true" ) {		
			User usr = UserDao.getByIdUser(request.getParameter("id"));
			int del = UserDao.delete(usr);	
			if(del == 1) {
				this.getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);	
				
			}
			if(del == 0) {
				this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);	
			}
			
		} else {
				 this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);	
				/* response.sendRedirect(getServletContext().getContextPath()+"/errorLogin.jsp"); */
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
