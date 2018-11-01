package com.yummy.user.controller;

import com.yummy.user.model.RequestUserParameters;
import com.yummy.user.model.StatusResponse;
import com.yummy.user.model.UserResponse;
import com.yummy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/info")
    public ResponseEntity<UserResponse> getUserInfo(@RequestHeader String email) {
        return ResponseEntity.ok(userService.getUserInfo(email));
    }


    @PostMapping(value = "user/create")
    public ResponseEntity<StatusResponse> createNewUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.createNewUser(requestUserParameters));
    }

    @PostMapping(value = "user/update")
    public ResponseEntity<StatusResponse> updateUser(@RequestHeader String email, @RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.updateUser(email, requestUserParameters));
    }

    @PostMapping(value = "user/delete")
    public ResponseEntity<StatusResponse> deleteUser(@RequestBody RequestUserParameters requestUserParameters) {
        return ResponseEntity.ok(userService.deleteUser(requestUserParameters.getEmail(), requestUserParameters.getPassword()));
    }

    @GetMapping(value = "user/bearer")
    public ResponseEntity<StatusResponse> checkBearer() {
        return ResponseEntity.ok(new StatusResponse(true));
    }

    @PostMapping(value = "user/password/reset")
    public ResponseEntity<StatusResponse> resetPassword(@RequestBody RequestUserParameters request){
        return UserService.resetPassword(request);
    }

    @PostMapping(value = "user/password/change")
    public ResponseEntity<StatusResponse> changePassword(@RequestBody RequestUserParameters request){
        return UserService.changePassword(request);
    }



}
