package com.core.AuthCore.domain.port.in;


import com.core.AuthCore.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {

    UserEntity CreateUser(UserEntity userEntity);
    Optional<UserEntity> getFindById(UUID id);
    List<UserEntity> GetAllUsers();
    Optional<UserEntity> updateUser(UUID id, UserEntity userEntity);
    UserEntity deleteUser(UUID id);

}
