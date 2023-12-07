package fpt.mantv.services.impl;

import fpt.mantv.entities.User;
import fpt.mantv.exceptions.DuplicateUserException;
import fpt.mantv.helper.StringHelper;
import fpt.mantv.repositories.UserRepository;
import fpt.mantv.repositories.impl.UserRepositoryImpl;
import fpt.mantv.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private Scanner scanner;
    public UserServiceImpl(UserRepository userRepository, Scanner scanner) {
        this.userRepository = userRepository;
        this.scanner = scanner;
    }
    @Override
    public void createUser() throws DuplicateUserException {
        User user;
        String username;
        while (true) {
            username = StringHelper.getUserInputString(scanner, "^[A-Za-z0-9_-]{5,15}$", "Enter username: "
                    , "Wrong format, username must be in 5-15 characters and contains only alphabet and digit " );
            if (checkExistUser(username)) {
                System.out.println("Duplicated username");
            } else {
                break;
            }
        }
        String password = StringHelper.getUserInputString(scanner, "^[A-Za-z0-9_-]{6,15}$", "Enter password: "
            ,"Wrong format, password must be in 6-15 characters contains only alphabet and digit");
        String confirmPassword;
        //get confirm password
        while (true) {
            confirmPassword = StringHelper.getUserInputString(scanner, "^[A-Za-z0-9_-]{6,15}$", "Enter confirm password: "
                    ,"Wrong format, password must be in 6-15 characters contains only alphabet and digit");
            if (confirmPassword.equals(password)) {
                break;
            } else {
                System.out.println("Confirm password is not equal to password!");
            }
        }
        String phoneNumber = StringHelper.getUserInputString(scanner, "^[0-9]{10}$","Enter Phonenumber: "
            , "Phonenumber must be 10 digits");
        String email = StringHelper.getUserInputString(scanner,"^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Enter email: ","Wrong format");
        String firstName = StringHelper.getUserInputString(scanner, "^[A-Z][a-zA-Z]*( [A-Z][a-zA-Z]*)*$", "Enter first name: "
                ,"Wrong format, each word must begin with capital character");
        String lastName = StringHelper.getUserInputString(scanner, "^[A-Z][a-zA-Z]*( [A-Z][a-zA-Z]*)*$", "Enter last name: "
                ,"Wrong format, each word must begin with capital character");


        user = new User(username,password,phoneNumber,email,firstName,lastName);
        userRepository.createUser(user);
    }

    @Override
    public boolean checkExistUser(String username) {
        return userRepository.checkExistUser(username);
    }

    @Override
    public List<User> searchUser(String name) {
        return userRepository.searchUser(name);
    }

    @Override
    public List<User> listAll() {
        return userRepository.listAllUser();
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
