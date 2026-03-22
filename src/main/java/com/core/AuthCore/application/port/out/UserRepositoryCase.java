package com.core.AuthCore.application.port.out;

import com.core.AuthCore.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryCase {

    UserEntity save(UserEntity userEntity);
    Optional<UserEntity> findById(UUID id);
    List<UserEntity> AllUsers();
    Optional<UserEntity> update(UUID id, UserEntity userEntity);
    boolean delete(UUID id);

}
