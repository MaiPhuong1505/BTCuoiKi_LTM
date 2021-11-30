package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.History;
import model.bo.History_BO;

/**
 * Servlet implementation class HistoryController
 */
@WebServlet("/History")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try
		{
			int ID = (int) session.getAttribute("id");
			ArrayList<History> arrayList = new History_BO().getAllHistory(ID);
			session.setAttribute("his", arrayList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/History.jsp");
			rd.forward(request, response);
			
		}
		catch (Exception e) {
			response.sendRedirect("/CK_LTM/Login");
		}
	}

}
