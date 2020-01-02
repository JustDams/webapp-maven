package web.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.project.dao.model.Post;

public class DAOPost {
	private Connection connection;

	public DAOPost(Connection co) {
		this.connection = co;
	}

	public String[] getPost(int id) {
		Post post = new Post();
		try {
			String query = "SELECT * FROM post WHERE id=?;";

			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next() == false) {
				return null;
			} else {
				do {
					post.setId(rs.getInt("id"));
					post.setAuthor(rs.getString("author"));
					post.setTitle(rs.getString("title"));
					post.setDescription(rs.getString("description"));
					post.setContent(rs.getString("content"));
					post.setDate(rs.getDate("date"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post.postString();
	}

	public List<String[]> getAllPosts() {
		List<String[]> a = new ArrayList<String[]>();

		try {
			String query = "SELECT * FROM POST ORDER BY date DESC;";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				a.add(new Post(rs.getInt("id"), rs.getString("author"), rs.getString("title"),
						rs.getString("description"), rs.getString("content"), rs.getDate("date")).postString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public void addPost(Post post) {
		try {
			String query = "INSERT INTO post(id,author,title,description,content,date) VALUES(null,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, post.getAuthor());
			ps.setString(2, post.getTitle());
			ps.setString(3, post.getDescription());
			ps.setString(4, post.getContent());
			ps.setDate(5, post.getDate());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<String> getAllWriters() {
		List<String> writers = new ArrayList<String>();
		try {
			String query = "SELECT DISTINCT author FROM post";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				writers.add(rs.getString("author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return writers;
	}

	public List<String[]> getAllPostsOf(String author) {
		List<String[]> posts = new ArrayList<String[]>();
		try {
			String query = "SELECT * FROM post where author = ?";
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setString(1, author);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				posts.add(new Post(rs.getInt("id"), rs.getString("author"), rs.getString("title"),
						rs.getString("description"), rs.getString("content"), rs.getDate("date")).postString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;
	}

	public void updatePost(Post post) {
		try {
			String query = "UPDATE post SET author=?, title=?, description=?, content=?, date=? WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, post.getAuthor());
			ps.setString(2, post.getTitle());
			ps.setString(3, post.getDescription());
			ps.setString(4, post.getContent());
			ps.setDate(5, post.getDate());
			ps.setInt(6, post.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePost(int id) {
		try {
			String query = "DELETE FROM post WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}