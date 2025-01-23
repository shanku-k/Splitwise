package dev.shanku.splitwise.controllers;

import dev.shanku.splitwise.dtos.SettleUpGroupRequestDto;
import dev.shanku.splitwise.dtos.SettleUpGroupResponseDto;
import dev.shanku.splitwise.dtos.SettleUpUserRequestDto;
import dev.shanku.splitwise.dtos.SettleUpUserResponseDto;
import dev.shanku.splitwise.models.User;
import dev.shanku.splitwise.services.SettleUpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //this controller is hosting rest apis
@RequestMapping("/settleUp") // to define the end point of all the apis written inside this controller

public class SettleUpController {
    private final SettleUpService settleUpService;
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }


    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto) {
        return null;
    }
    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto) {
        return null;
    }
}
