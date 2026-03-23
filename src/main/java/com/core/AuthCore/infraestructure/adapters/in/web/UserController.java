package com.core.AuthCore.infraestructure.adapters.in.web;


import com.core.AuthCore.application.port.in.UserUseCase;
import com.core.AuthCore.domain.model.UserModel;
import com.core.AuthCore.infraestructure.adapters.dto.request.CreateUserRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserModel> createUser(@RequestBody CreateUserRequest request) {
            UserModel userEntity = userUseCase.CreateUser(
                    request.getUsername(),
                    request.getPassword(),
                    request.getEmail(),
                    request.getPhone()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(userEntity);
    }
}



