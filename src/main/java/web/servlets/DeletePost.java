package web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOPost;

public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		if (request.getParameter("post") != null) {
			daoPost.deletePost(Integer.parseInt(request.getParameter("post")));
			request.setAttribute("success", true);
		}

		List<String[]> allPosts = daoPost.getAllPosts();

		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);
		request.setAttribute("allPosts", allPosts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/allPosts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
