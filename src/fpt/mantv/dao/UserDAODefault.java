package fpt.mantv.dao;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//Using for bytes file
public class UserDAODefault extends UserDAO{
    public UserDAODefault(String fileName) {
        super(fileName);
    }

    @Override
    public List<User> readUsers() throws DAOException {
        List<User> users = new ArrayList<>();
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            User user;
            try{
                while ((user = ((User) ois.readObject())) != null ){
                    users.add(user);
                }
            } catch (EOFException e){

            }
            ois.close();
        }
        catch (ClassNotFoundException | IOException e) {
            throw new DAOException(e.getMessage());
        }
        return users;
    }

    @Override
    public void writeUser(List<User> users) throws DAOException, IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            for (User user: users){
                oos.writeObject(user);
            }
        } finally {
            assert fos != null;
            assert oos != null;
            oos.close();
            fos.close();
        }
    }
}
