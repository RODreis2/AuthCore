package com.core.AuthCore.application.port.in;


import com.core.AuthCore.domain.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserUseCase {

    UserModel CreateUser(String username, String password, String email, String phone);
    Optional<UserModel> getFindById(UUID id);
    List<UserModel> GetAllUsers();
    Optional<UserModel> updateUser(UUID id, UserModel userEntity);
    boolean deleteUser(UUID id);

}
