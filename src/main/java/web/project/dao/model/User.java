package web.project.dao.model;

public class User {
	
	public String chiffrer(String password) {
		String key = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			key = key + (char) c;
		}
		return key;
	}

	public String dechiffrer(String password) {
		String key = "";
		for (int i = 0; i < password.length(); i++) {
			int c = password.charAt(i) ^ 48;
			key = key + (char) c;
		}
		return key;
	}
}
