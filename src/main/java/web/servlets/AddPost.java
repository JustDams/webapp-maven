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
 * Servlet implementation class addPost
 */
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);

		this.getServletContext().getRequestDispatcher("/WEB-INF/postForm.jsp").forward(request, response);
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

		if (request.getParameter("Auteur") != "" && request.getParameter("Titre") != ""
				&& request.getParameter("Description") != "" && request.getParameter("Texte") != "" ) {
			daoPost.addPost(new Post(0, request.getParameter("Auteur"), request.getParameter("Titre"),
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
