package web.project.dao;

public class DAOFactory {

    private MySQLManager mySQLManager;
    private DAOPost daoPost;

    public DAOPost getDaoPost() {
        return daoPost;
    }

    public DAOFactory() {
        mySQLManager = MySQLManager.getInstance();
        daoPost = new DAOPost(mySQLManager.getConnection());
    }
}