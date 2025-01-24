package dev.shanku.splitwise.commands;

import dev.shanku.splitwise.controllers.UserController;
import dev.shanku.splitwise.dtos.RegisterUserRequestDto;
import dev.shanku.splitwise.dtos.RegisterUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {
    //Register vinsmokesanji 003 namisswwaann
    private UserController userController;
    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words= List.of(input.split(" "));

        return words.size() == 4 && words.get(0).equals(CommandKeywords.registerCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words= List.of(input.split(" "));
        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();

        requestDto.setUsername(words.get(1));
        requestDto.setPhoneNumber(words.get(2));
        requestDto.setPassword(words.get(3));

        RegisterUserResponseDto responseDto = userController.registerUser(requestDto);
    }
}
//TO-DO  implement this functionality in user controller class