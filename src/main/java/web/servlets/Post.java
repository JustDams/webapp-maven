package web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOPost;

public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		String[] post = null;

		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			post = daoPost.getPost(id);
		}

		String user = request.getParameter("user");

		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);
		request.setAttribute("allPosts", daoPost.getAllPostsOf(user));
		request.setAttribute("post", post);

		this.getServletContext().getRequestDispatcher("/WEB-INF/post.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
