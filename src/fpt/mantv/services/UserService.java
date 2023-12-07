package fpt.mantv.services;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DuplicateUserException;

import java.util.List;

public interface UserService {
    void createUser() throws DuplicateUserException;
    boolean checkExistUser(String username);
    List<User> searchUser(String name);
    List<User> listAll();
    void updateUser();
    void deleteUser();
}
