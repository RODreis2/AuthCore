package com.core.AuthCore.infraestructure.adapters.mapper;

import com.core.AuthCore.domain.model.UserModel;
import com.core.AuthCore.infraestructure.adapters.dto.response.UserResponse;

public class UserMapper {

    public static UserResponse toResponse(UserModel user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword()
        );
}
}
