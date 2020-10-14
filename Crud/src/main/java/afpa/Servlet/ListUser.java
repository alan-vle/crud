package afpa.Servlet;

import afpa.Beans.User;
import afpa.DAO.UserDao;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.sql.SQLException;
>>>>>>> branch 'master' of https://github.com/sed125/crud
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Listutilisateur
 */
@WebServlet(name="ListUser", urlPatterns="/admin/ListUser")
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserDao adminUserDao;
	List<User> listUser;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUser() {
        super();
        listUser = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		executeQuery(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executeQuery(request, response);		
	}
	private void executeQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminUserDao = new UserDao();
		listUser = adminUserDao.getAllRecords();
		request.setAttribute("userList", listUser);
		this.getServletContext().getRequestDispatcher("/viewUserList.jsp").forward(request, response);
	}
	
}