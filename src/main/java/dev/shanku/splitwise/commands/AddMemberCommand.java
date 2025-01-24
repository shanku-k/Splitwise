package dev.shanku.splitwise.commands;

import dev.shanku.splitwise.controllers.UserController;
import dev.shanku.splitwise.dtos.AddMemberRequestDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component //at the time of application initialization, all component class objects will get created automatically
public class AddMemberCommand implements Command {
    //u1 AddMember g1 u2
    private UserController userController;
    public AddMemberCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words= Arrays.asList(input.split(" "));
        return words.size()==4 && words.get(1).equals(CommandKeywords.addMemberCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words= Arrays.asList(input.split(" "));
        Long adminId = Long.parseLong(words.get(0));
        Long groupId = Long.parseLong(words.get(2));
        Long userId = Long.parseLong(words.get(3));

        AddMemberRequestDto requestDto= new AddMemberRequestDto();
        requestDto.setAdminId(adminId);
        requestDto.setGroupId(groupId);
        requestDto.setUserId(userId);

        userController.addMember(requestDto);
    }
}
