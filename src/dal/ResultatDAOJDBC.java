package dal;

import bo.Resultat;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class ResultatDAOJDBC extends DataAccessObjJDBC<Resultat> {
    private static final String INSERT_RESULTAT_QUERY = "INSERT INTO resultat (score, dateHeure, idUser) VALUES (?, ?, ?)";

    public ResultatDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(Resultat object) {
        try(Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
            PreparedStatement ps = connection.prepareStatement(INSERT_RESULTAT_QUERY))
        {
            ps.setInt(1, object.getScore());
            ps.setTimestamp(2, object.getDateHeure());
            ps.setInt(3, object.getIdUser());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Resultat> findAll() throws SQLException {
        return null;
    }

    @Override
    public void update(Resultat object) throws SQLException {

    }
}