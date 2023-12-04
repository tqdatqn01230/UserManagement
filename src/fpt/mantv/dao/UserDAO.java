package fpt.mantv.dao;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public abstract class UserDAO {
    public abstract List<User> readUsers() throws IOException, DAOException;
    public abstract void writeUser(List<User> users) throws DAOException, IOException;
    protected String fileName;
    public UserDAO(String fileName) {
        this.fileName = fileName;
    }
}
