package dal;

import bo.Resultat;
import bo.User;

import javax.servlet.ServletContext;

public class DAOFactory {
    private static String dbUrl;
    private static String dbLogin;
    private static String dbPwd;

    public static void init(ServletContext context) throws ClassNotFoundException {
        Class.forName(context.getInitParameter("DB_DRIVER"));
        dbUrl = context.getInitParameter("DB_URL");
        dbLogin = context.getInitParameter("DB_LOGIN");
        dbPwd = context.getInitParameter("DB_PWD");
    }


    //fabrication de l'objet UserDAO
    public static IDAO<User> getUserDAO() {
        IDAO<User> dao;
        dao = new UserDAOJDBC(dbUrl, dbLogin, dbPwd);
        return dao;
    }

    //fabrication de l'objet Resultat DAO
    public static IDAO<Resultat> getResultatDAO(){
        IDAO<Resultat> dao;
        dao = new ResultatDAOJDBC(dbUrl, dbLogin, dbPwd);
        return dao;
    }
}
