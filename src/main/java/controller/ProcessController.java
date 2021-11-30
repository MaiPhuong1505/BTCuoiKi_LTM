package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.Thread_BO;

/**
 * Servlet implementation class ProcessController
 */
@WebServlet(urlPatterns = "/Homepage")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProcessController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int ID = -1;
		try {
			ID = (int) session.getAttribute("id");
		} catch (Exception e) {
			System.out.println(e);
		}
		if (ID == -1) {
			session.setAttribute("error", "Error, please try later");
			response.sendRedirect("/CK_LTM/Login");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
		{
			HttpSession session = request.getSession();
			int ID = (int) session.getAttribute("id");

			int mode = Integer.parseInt(request.getParameter("mode"));
			if(mode == 1)
			{
				int n = Integer.parseInt(request.getParameter("txtNumber"));
				Thread_BO d = new Thread_BO();
				d.caculate_factorial(n, ID);
			}
			else {
				int base = Integer.parseInt(request.getParameter("txtBase"));
				int ex = Integer.parseInt(request.getParameter("txtExpo")); 
				Thread_BO d = new Thread_BO();
				d.calculate_exponent(base, ex, ID);
			}

			session.setAttribute("res", "true");
			response.sendRedirect("/CK_LTM/Homepage");
		}catch (Exception e) {
			System.out.println(e);
			return;
		}
	}
}