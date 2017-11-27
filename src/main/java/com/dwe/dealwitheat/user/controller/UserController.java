package com.dwe.dealwitheat.user.controller;

import com.dwe.dealwitheat.user.model.RequestUserParameters;
import com.dwe.dealwitheat.user.model.StatusResponse;
import com.dwe.dealwitheat.user.model.UserResponse;
import com.dwe.dealwitheat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "userInfo")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader String nickname, @RequestHeader String password) {
        return ResponseEntity.ok(userService.getUserInfo(nickname, password));
    }


    @PostMapping(value = "createUser")
    public ResponseEntity<StatusResponse> createNewUser(@RequestHeader long id, @RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.createNewUser(requestUserParameters));
    }

    @PostMapping(value = "deleteUser")
    public ResponseEntity<StatusResponse> deleteUser(@RequestHeader long id, @RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.deleteUser(id, requestUserParameters.getPassword()));
    }


}
