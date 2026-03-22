package com.core.AuthCore.application.port.out;

public interface PasswordHasher {

    String hash(String password);

    boolean checkPassword(String password, String hashedPassword);
}
