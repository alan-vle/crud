package afpa.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import afpa.Beans.User;
import afpa.DAO.UserDao;

/**
 * Servlet implementation class addUs
 */
@WebServlet(name="addUs", urlPatterns="/admin/addUs")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    		if( session.getAttribute("admin") == "true" ) {
    			this.getServletContext().getRequestDispatcher("/addUser.jsp").forward(request, response);
    		} else {
    			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
    		}
    	
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User usr = new User();
		String id = request.getParameter("id");
		int ide = Integer.parseInt(id);

		usr.setIdUser(ide);
		usr.setFirstName(request.getParameter("firstName"));
		usr.setLastName(request.getParameter("lastName"));
		usr.setLogin(request.getParameter("login"));
		usr.setPassword(request.getParameter("password"));
	
		int insert = UserDao.insert(usr);
		if(insert == 1) {
			this.getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);	
		} 
		if (insert == 0){
			this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);	
		}
	}

}
