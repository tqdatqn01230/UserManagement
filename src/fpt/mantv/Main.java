package fpt.mantv;

import fpt.mantv.dao.UserDAO;
import fpt.mantv.dao.UserDAODefault;
import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.SequenceInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DAOException, IOException {
        List<User> userList = new ArrayList<>();

//        for (int i = 1; i <= 10; i++) {
//            String username = "user" + i;
//            String password = "password" + i;
//            String phoneNumber = "123-456-789" + i;
//            String email = "user" + i + "@example.com";
//
//            User user = new User(username, password, phoneNumber, email);
//            userList.add(user);
//        }
//        UserDAO userDAO = new UserDAODefault("user.dat");
//        userDAO.writeUser(userList);

        UserDAO userDAO = new UserDAODefault("user.dat");
        List<User> users = userDAO.readUsers();
        users.forEach(System.out::println);
    }
}