package web.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOPost;
import web.project.dao.model.Post;

public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/postForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		Date now = new Date(System.currentTimeMillis());

		Object co = request.getSession().getAttribute("connected");
		request.setAttribute("connected", co);

		if (request.getParameter("Titre") != null && request.getParameter("Description") != null
				&& request.getParameter("Texte") != null) {
			if (request.getParameter("Auteur") == null && co != null) {
				daoPost.addPost(new Post(0, request.getSession().getAttribute("username").toString(),
						request.getParameter("Titre"), request.getParameter("Description"),
						request.getParameter("Texte"), now));
				request.setAttribute("success", true);
			} else if (request.getParameter("Auteur") != null) {
				daoPost.addPost(new Post(0, request.getParameter("Auteur"), request.getParameter("Titre"),
						request.getParameter("Description"), request.getParameter("Texte"), now));
				request.setAttribute("success", true);
			} else {
				request.setAttribute("error", true);
			}
		} else {
			request.setAttribute("error", true);
		}
		doGet(request, response);
	}
}