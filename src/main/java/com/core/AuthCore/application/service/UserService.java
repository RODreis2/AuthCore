package com.core.AuthCore.application.service;

import com.core.AuthCore.domain.model.UserModel;
import com.core.AuthCore.application.port.in.UserUseCase;
import com.core.AuthCore.application.port.out.PasswordHasher;
import com.core.AuthCore.application.port.out.UserRepositoryCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserService implements UserUseCase {

    private final UserRepositoryCase userRepositoryCase;
    private final PasswordHasher passwordHasher;

    public UserService(UserRepositoryCase userRepositoryCase, PasswordHasher passwordHasher) {
        this.userRepositoryCase = userRepositoryCase;
        this.passwordHasher = passwordHasher;
    }

    @Override
    public UserModel CreateUser(String username, String password, String email, String phone) {

        String hashedPassword = passwordHasher.hash(password);
        UserModel user = new UserModel(username, email, password,phone);
        return userRepositoryCase.save(user);
    }

    @Override
    public Optional<UserModel> getFindById(UUID id){
        return userRepositoryCase.findById(id);
    };

    @Override
    public List<UserModel> GetAllUsers(){
        return userRepositoryCase.AllUsers();
    };

    @Override
    public Optional<UserModel> updateUser(UUID id, UserModel userEntity){
        return userRepositoryCase.update(id, userEntity);
    };

    @Override
    public boolean deleteUser(UUID id){
        if (!userRepositoryCase.findById(id).isPresent()) {
            return false;
        }
         userRepositoryCase.delete(id);
        return true;
    };

}
