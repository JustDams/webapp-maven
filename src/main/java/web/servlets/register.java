package web.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOUser;
import web.project.dao.model.User;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/registerForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();

		if (request.getParameter("Usename") != "" && request.getParameter("Password") != ""
				&& request.getParameter("PasswordRep") != "") {
			if (request.getParameter("Password").equals(request.getParameter("PasswordRep"))) {
				try {
					boolean success = daoUser
							.addUser(new User(0, request.getParameter("Username"), request.getParameter("Password")));
					request.setAttribute("success", success);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("pass", true);
			}
		} else {
			request.setAttribute("error", true);
		}

		doGet(request, response);
	}

}
