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
 * Servlet implementation class DeleteController
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try 
		{
			int ID = (int) session.getAttribute("id");
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			System.out.println(num1 + ", " + num2);
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			new History_BO().deleteHistory(ID, a, b);
			ArrayList<History> arrayList = new History_BO().getAllHistory(ID);
			session.setAttribute("his", arrayList);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/History.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			response.sendRedirect("/CK_LTM/Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
