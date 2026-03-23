package com.core.AuthCore.infraestructure.adapters.mapper;

import com.core.AuthCore.domain.model.UserModel;

public class UserEntityMapper {

    public static UserModel toEntity(UserModel user){
        UserModel entity = new UserModel();
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setPhone(user.getPhone());
        return entity;
    }

    public static UserModel toDomain(UserModel entity){
        return new UserModel(
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getPhone()
        );
    }
}
