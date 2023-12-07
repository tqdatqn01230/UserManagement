package fpt.mantv.repositories.impl;

import fpt.mantv.dao.FileDAO;
import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DAOException;
import fpt.mantv.exceptions.DuplicateUserException;
import fpt.mantv.helper.StringHelper;
import fpt.mantv.repositories.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    private List<User> users;
    private FileDAO<User> userDAO;
    public UserRepositoryImpl(FileDAO<User> dao) {
        userDAO = dao;
    }
    @Override
    public void loadData() throws DAOException, IOException {
        users = userDAO.readUsers();
    }

    @Override
    public void saveData() throws DAOException, IOException {
        userDAO.writeUser(users);
    }

    @Override
    public void createUser(User user) throws DuplicateUserException {
        if (checkExistUser(user.getUsername())) {
            throw new DuplicateUserException(String.format("%s is duplicated!", user.getUsername()));
        }
        users.add(user);
    }

    @Override
    public boolean checkExistUser(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    @Override
    public List<User> searchUser(String name) {
        if (StringHelper.isEmpty(name)) {
            return new ArrayList<>();
        }
        return users.stream()
                .filter(user -> user.getFirstName().toLowerCase().contains(name.toLowerCase()) || user.getLastName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> listAllUser() {
       return users;
    }

    @Override
    public void updateUser(String username) {

    }

    @Override
    public void deleteUser(String username) {
        users = users.stream()
                .filter(user -> !user.getUsername().equals(username))
                .collect(Collectors.toList());
    }
}
