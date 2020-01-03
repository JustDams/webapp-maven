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

	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		List<String[]> allPosts = daoPost.getAllPosts();
		List<String[]> latestPosts = new ArrayList<String[]>();
		String userAgent = request.getHeader("User-Agent");
		
		if (userAgent.indexOf("Windows NT 6.2") != -1) {
			request.setAttribute("browser",true);
		}		
		
		if (allPosts.size() >= 2) {
			latestPosts.add(allPosts.get(0));
			latestPosts.add(allPosts.get(1));
		} else if(allPosts.size() == 1) {
			latestPosts.add(allPosts.get(0));
		}
		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);
		request.setAttribute("latestPosts", latestPosts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		doGet(request, resp);
	}

}
