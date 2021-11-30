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
 * Servlet implementation class HistoryDetailController
 */
@WebServlet("/HistoryDetail")
public class HistoryDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryDetailController() {
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
			String num1 = request.getParameter("num1");
			String num2 = request.getParameter("num2");
			int a = Integer.parseInt(num1);
			int b = Integer.parseInt(num2);
			ArrayList<History> arrayList = new History_BO().getAllHistory(ID);
			for(History i : arrayList)
			{
				if(i.getInput() == a && i.getInput2() == b)
				{
					session.setAttribute("his",i);
					break;
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewResult.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
			response.sendRedirect("/CK_LTM/Login");
		}
	}

}
