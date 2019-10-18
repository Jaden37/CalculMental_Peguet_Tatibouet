package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class HomeBean implements Serializable {
    private List<User> listUsers;

    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    public HomeBean() {
    }

    public void getUsers(){
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        try {
            listUsers = dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
