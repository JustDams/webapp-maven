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

/**
 * Servlet implementation class ModifyPost
 */
public class ModifyPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		Date now = new Date(System.currentTimeMillis());

		int postId = 0;

		if (request.getParameter("post") != null) {
			postId = Integer.parseInt(request.getParameter("post"));
		}

		if (request.getParameter("Auteur") != "" && request.getParameter("Titre") != ""
				&& request.getParameter("Description") != "" && request.getParameter("Texte") != "") {
			daoPost.updatePost(new Post(postId, request.getParameter("Auteur"), request.getParameter("Titre"),
					request.getParameter("Description"), request.getParameter("Texte"), now));

			boolean success = true;
			request.setAttribute("success", success);
		} else {
			boolean error = true;
			request.setAttribute("error", error);
		}

		doGet(request, response);
	}

}
