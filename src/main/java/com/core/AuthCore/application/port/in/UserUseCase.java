package com.core.AuthCore.application.port.in;


import com.core.AuthCore.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {

    UserEntity CreateUser(String username, String password, String email, String phone);
    Optional<UserEntity> getFindById(UUID id);
    List<UserEntity> GetAllUsers();
    Optional<UserEntity> updateUser(UUID id, UserEntity userEntity);
    boolean deleteUser(UUID id);

}
