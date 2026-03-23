package com.core.AuthCore.application.port.out;

import com.core.AuthCore.domain.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryCase {

    UserModel save(UserModel userEntity);
    Optional<UserModel> findById(UUID id);
    List<UserModel> AllUsers();
    Optional<UserModel> update(UUID id, UserModel userEntity);
    boolean delete(UUID id);

}
