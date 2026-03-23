package com.core.AuthCore.infraestructure.adapters.dto.response;

import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String username;
    private String email;
    private String phone;

    public UserResponse(UUID id, String username, String email, String phone, String password) {
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponse(UUID id, String username, String email)
        {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        }
}
