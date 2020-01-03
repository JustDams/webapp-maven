package web.project.dao.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
	private String username;
	private String password;
	private int id;

	public User(int id,String username, String password) throws NoSuchAlgorithmException {
		this.id = id;
		this.username = username;
		this.password = chiffrer(password).toString();
	}

	public String getPassword() throws NoSuchAlgorithmException {
		return password.toString();
	}

	public void setPassword(String password) throws NoSuchAlgorithmException {
		this.password = chiffrer(password).toString();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private StringBuffer chiffrer(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb;
	}
	
	public String[] userString() {
		String[] a = {this.username, this.password};
		return a;
	}
}
