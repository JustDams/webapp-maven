package web.project.dao;

public class DAOFactory {

	private MySQLManager mySQLManager;
	private DAOPost daoPost;
	private DAOUser daoUser;

	public DAOPost getDaoPost() {
		return daoPost;
	}

	public DAOUser getDaoUser() {
		return daoUser;
	}

	public DAOFactory() {
		mySQLManager = MySQLManager.getInstance();
		daoPost = new DAOPost(mySQLManager.getConnection());
		daoUser = new DAOUser(mySQLManager.getConnection());
	}
}