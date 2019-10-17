package dal;

import bo.User;
import listener.AppListener;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAOJDBC extends DataAccessObjJDBC<User> {

    private static final String AUTH_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final Logger LOGGER = Logger.getLogger( UserDAOJDBC.class.getName() );

    public UserDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(User object) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User authentificate(String login, String password) throws SQLException{
        User user = null;
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(AUTH_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE) )
        {
            ps.setString(1, login);
            ps.setString(2, password);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()){
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setBestScore(rs.getInt("bestscore"));
                    LOGGER.log(Level.INFO, "Utilisateur recup");
                }
                else {
                    LOGGER.log(Level.INFO, "Aucun utilisateur");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
