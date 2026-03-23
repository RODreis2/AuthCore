package com.core.AuthCore.infraestructure.adapters.in;


import com.core.AuthCore.application.port.in.UserUseCase;
import com.core.AuthCore.application.port.out.UserRepositoryCase;
import com.core.AuthCore.domain.entity.UserEntity;
import com.core.AuthCore.infraestructure.dto.CreateUserRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Getter
@Setter
public class UserController {

    private final CreateUserRequest createUserRequest;
    private final UserUseCase userUseCase;


    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody CreateUserRequest request) {
            UserEntity userEntity = userUseCase.CreateUser(
                    request.getUsername(),
                    request.getPassword(),
                    request.getEmail(),
                    request.getPhone()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }
}



