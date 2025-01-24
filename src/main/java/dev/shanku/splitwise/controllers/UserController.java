package dev.shanku.splitwise.controllers;

import dev.shanku.splitwise.dtos.AddMemberRequestDto;
import dev.shanku.splitwise.dtos.RegisterUserRequestDto;
import dev.shanku.splitwise.dtos.RegisterUserResponseDto;
import dev.shanku.splitwise.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequestDto) {
        System.out.println("Register user command");
        return null;
    }

    public ResponseEntity<Void> addMember(AddMemberRequestDto addMemberRequestDto) {
        return null;
    }
}
