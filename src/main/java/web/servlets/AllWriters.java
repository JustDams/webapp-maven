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

public class AllWriters extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DAOFactory factory = new DAOFactory();
		DAOPost daoPost = factory.getDaoPost();

		List<String> allWriters = daoPost.getAllWriters();
		List<String> postNumber= new ArrayList<String>();
		
		int size = allWriters.size() - 1;

		for (int i = 0; i < allWriters.size(); i++) {
			postNumber.add(daoPost.getAllPostsOf(allWriters.get(i)).size() + "");
		}
		Object co = request.getSession().getAttribute("connected");

		request.setAttribute("connected", co);
		request.setAttribute("size", size);
		request.setAttribute("postNumber", postNumber);
		request.setAttribute("allWriters", allWriters);

		this.getServletContext().getRequestDispatcher("/WEB-INF/allWriters.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
