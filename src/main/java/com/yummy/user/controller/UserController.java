package com.yummy.user.controller;

import com.yummy.user.model.RequestUserParameters;
import com.yummy.user.model.StatusResponse;
import com.yummy.user.model.UserResponse;
import com.yummy.user.service.UserService;
import com.yummy.user.service.UserService;
import com.yummy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "userInfo")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader String email, @RequestHeader String password) {
        return ResponseEntity.ok(userService.getUserInfo(email, password));
    }


    @PostMapping(value = "user/create")
    public ResponseEntity<StatusResponse> createNewUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.createNewUser(requestUserParameters));
    }

    @PostMapping(value = "user/delete")
    public ResponseEntity<StatusResponse> deleteUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.deleteUser(requestUserParameters.getEmail(), requestUserParameters.getPassword()));
    }


}
