package com.core.AuthCore.infraestructure.adapters.out.persistence;

import com.core.AuthCore.application.port.out.UserRepositoryCase;
import com.core.AuthCore.domain.model.UserModel;
import com.core.AuthCore.infraestructure.adapters.mapper.UserEntityMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryAdapter implements UserRepositoryCase {

    private final JpaUserRepository repository;

    public UserRepositoryAdapter(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserModel save(UserModel userEntity){
        UserModel entity = new UserModel(userEntity);
        UserModel saved = repository.save(entity);
        return UserEntityMapper.toEntity(saved);
    }
    @Override
    public Optional<UserModel> findById(UUID id){
        if(id == null){
            return Optional.empty();
        }
        return repository.findById(id);
    }
    @Override
    public List<UserModel> AllUsers()  {
        return repository.findAll();
    }
    @Override
    public Optional<UserModel> update(UUID id, UserModel userEntity) {

        if (id == null) {
            return Optional.empty();
        }

        Optional<UserModel> existingUserOpt = repository.findById(id);

        if (existingUserOpt.isEmpty()) {
            return Optional.empty();
        }

        UserModel existingUser = existingUserOpt.get();

        existingUser.setUsername(userEntity.getUsername());
        existingUser.setEmail(userEntity.getEmail());
        existingUser.setPassword(userEntity.getPassword());
        existingUser.setPhone(userEntity.getPhone());

        UserModel updatedUser = repository.save(existingUser);

        return Optional.of(updatedUser);
    }

    @Override
    public boolean delete(UUID id){
        if (id == null) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }


}
