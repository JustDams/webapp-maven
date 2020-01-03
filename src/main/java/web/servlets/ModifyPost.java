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

public class ModifyPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		Object co = request.getSession().getAttribute("connected");
		String[] post = null;

		if (request.getParameter("post") != null) {
			int postId = Integer.parseInt(request.getParameter("post"));
			post = daoPost.getPost(postId);
		}

		request.setAttribute("post", post);
		request.setAttribute("connected", co);

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifyPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		Date now = new Date(System.currentTimeMillis());

		int postId = 0;

		Object co = request.getSession().getAttribute("connected");
		request.setAttribute("connected", co);

		if (request.getParameter("post") != null) {
			postId = Integer.parseInt(request.getParameter("post"));
		}

		if (request.getParameter("Titre") != null && request.getParameter("Description") != null
				&& request.getParameter("Texte") != null) {
			if (request.getParameter("Auteur") == null && co != null) {
				if (request.getParameter("Titre").length() > 40) {
					request.setAttribute("titlelen", true);
				} else {
					daoPost.updatePost(new Post(postId, request.getSession().getAttribute("username").toString(),
							request.getParameter("Titre"), request.getParameter("Description"),
							request.getParameter("Texte"), now));

					request.setAttribute("success", true);
				}
			} else if (request.getParameter("Auteur") != null) {
				if (request.getParameter("Auteur").length() > 30) {
					request.setAttribute("authorlen", true);
				} else if (request.getParameter("Titre").length() > 40) {
					request.setAttribute("titlelen", true);
				} else {
					daoPost.updatePost(new Post(postId, request.getParameter("Auteur"), request.getParameter("Titre"),
							request.getParameter("Description"), request.getParameter("Texte"), now));

					request.setAttribute("success", true);
				}
			} else {
				request.setAttribute("error", true);
			}
		} else

		{
			request.setAttribute("error", true);
		}

		doGet(request, response);
	}
}
