package com.core.AuthCore.infraestructure.adapters.out.persistence;

import com.core.AuthCore.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<UserModel, UUID> {
}
