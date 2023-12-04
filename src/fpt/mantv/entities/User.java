package fpt.mantv.entities;

import java.io.Serializable;

public class User implements Serializable {
    private final long serialVersionUID = 741751L;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    public User(){
    }

    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User Information: [Username: %s, Password: %s, Phone Number: %s, Email: %s]",
                username, password, phoneNumber, email);
    }
}
