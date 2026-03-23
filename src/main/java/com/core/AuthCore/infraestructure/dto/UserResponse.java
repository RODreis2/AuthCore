package com.core.AuthCore.infraestructure.dto;

import com.core.AuthCore.application.port.out.UserRepositoryCase;

import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String username;
    private String password;
    private String email;
    private String phone;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponse(UUID id, String username, String password, String email, String phone)
        {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        }
}
