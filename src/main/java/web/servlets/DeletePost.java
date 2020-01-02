package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOPost;

/**
 * Servlet implementation class DeletePost
 */
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePost() {
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
		
		if (request.getParameter("post") != null) {
			daoPost.deletePost(Integer.parseInt(request.getParameter("post")));
			boolean delete = true;
			request.setAttribute("success", delete);
		}

		List<String[]> allPosts = daoPost.getAllPosts();

		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);
		request.setAttribute("allPosts", allPosts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/allPosts.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
