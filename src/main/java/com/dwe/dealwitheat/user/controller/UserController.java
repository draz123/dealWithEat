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
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader String email, @RequestHeader String password) {
        return ResponseEntity.ok(userService.getUserInfo(email, password));
    }


    @PostMapping(value = "user")
    public ResponseEntity<StatusResponse> createNewUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.createNewUser(requestUserParameters));
    }

    @PostMapping(value = "user/delete")
    public ResponseEntity<StatusResponse> deleteUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.deleteUser(requestUserParameters.getEmail(), requestUserParameters.getPassword()));
    }


}
