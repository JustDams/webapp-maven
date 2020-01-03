package web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.project.dao.DAOFactory;
import web.project.dao.DAOPost;

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		List<String[]> allPosts = daoPost.getAllPosts();

		List<String[]> latestPosts = new ArrayList<String[]>();
		
		if (allPosts.size() >= 2) {
			latestPosts.add(allPosts.get(0));
			latestPosts.add(allPosts.get(1));
		} else if(allPosts.size() == 1) {
			latestPosts.add(allPosts.get(0));
		}
		Object co = req.getSession().getAttribute("connected");

		req.setAttribute("connected", co);
		req.setAttribute("latestPosts", latestPosts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
