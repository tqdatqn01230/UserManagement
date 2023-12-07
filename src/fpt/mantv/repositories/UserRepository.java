package fpt.mantv.repositories;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DuplicateUserException;

import java.util.List;

public interface UserRepository extends BaseRepository{
    void createUser(User user) throws DuplicateUserException;
    boolean checkExistUser(String username);
    List<User> searchUser(String name);
    List<User> listAllUser();
    void updateUser(String username);
    void deleteUser(String username);
}
