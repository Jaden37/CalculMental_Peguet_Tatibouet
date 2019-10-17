package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class ConnexionBean implements Serializable {
    private static final String FORM_FIELD_LOGIN = "login";
    private static final String FORM_FIELD_PASSWORD = "password";
    private static final String AUTH_SESSION = "isConnected";

    private String login;
    private String password;
    private String authentResult;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthentResult() {
        return authentResult;
    }

    public void setAuthentResult(String authentResult) {
        this.authentResult = authentResult;
    }

    public ConnexionBean() {
    }

    public void authentificate(HttpServletRequest request){
        login = request.getParameter(FORM_FIELD_LOGIN);
        password = request.getParameter(FORM_FIELD_PASSWORD);

        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = null;
        try {
            user = dao.authentificate(login, password);
            if(user != null){
                HttpSession session = request.getSession(true);
                session.setAttribute(AUTH_SESSION, user);
                authentResult = "Connexion réussie";
            }else {
                authentResult = "Connexion impossible vérifier les identifiants";
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            authentResult = "Service indisponible pour le moment";
        }
    }

    public boolean isConnected(HttpServletRequest request){
        HttpSession session = request.getSession();
        User connectedUser = (User) session.getAttribute(AUTH_SESSION);
        return connectedUser != null;
    }
}
