package fpt.mantv.repositories;

import fpt.mantv.exceptions.DAOException;

import java.io.IOException;

public interface BaseRepository {
    //Load data using DAO
    void loadData() throws DAOException, IOException;
    //Save data using DAO
    void saveData() throws DAOException, IOException;
}
