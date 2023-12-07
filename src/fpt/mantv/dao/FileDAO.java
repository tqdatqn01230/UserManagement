package fpt.mantv.dao;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileDAO<T> {
    public abstract List<T> readUsers() throws IOException, DAOException;
    public abstract void writeUser(List<T> users) throws DAOException, IOException;

}
