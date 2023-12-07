package fpt.mantv;

import fpt.mantv.dao.FileDAO;
import fpt.mantv.dao.impl.UserDAODefault;
import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DAOException, IOException {
        FileDAO<User> userDAO = new UserDAODefault("user.dat");
        List<User> users = userDAO.readUsers();
        users.forEach(System.out::println);
    }
}