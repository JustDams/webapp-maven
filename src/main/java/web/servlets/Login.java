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

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOUser daoUser = factory.getDaoUser();
		
		if (request.getParameter("Username") != "" && request.getParameter("Password") != "") {
			try {
				if (daoUser.checkUser(new User(0,request.getParameter("Username"),request.getParameter("Password")))) {
					request.getSession().setAttribute("connected", true);
					request.setAttribute("connected", true);
					request.getSession().setAttribute("username",request.getParameter("Username"));
				} else {
					request.setAttribute("error", true);
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("vide", true);
		}

		
		doGet(request, response);
	}

}
