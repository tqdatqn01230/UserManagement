package fpt.mantv.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHelper {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = messageDigest.digest(password.getBytes());

        // Convert hashed bytes to hexadecimal representation
        StringBuilder hexStringBuilder = new StringBuilder();
        for (byte hashedByte : hashedBytes) {
            hexStringBuilder.append(String.format("%02x", hashedByte));
        }

        return hexStringBuilder.toString();
    }
}
