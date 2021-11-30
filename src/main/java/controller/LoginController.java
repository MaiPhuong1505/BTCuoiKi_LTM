package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.Account_DAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name  = request.getParameter("txtUN");
		String pass = request.getParameter("txtPW");
		HttpSession session = request.getSession();
		int ID = new Account_DAO().getID(name, pass);
		if(ID == -1)
		{
			session.setAttribute("error", "Account not exist, please try later");
			response.sendRedirect("/CK_LTM/Login");
		}
		else {
			session.setAttribute("id", ID);
			session.setAttribute("user", name);
			response.sendRedirect("/CK_LTM/Homepage");
		}
	}

}
