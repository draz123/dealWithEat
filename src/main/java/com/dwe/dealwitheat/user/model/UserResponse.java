package com.dwe.dealwitheat.user.model;

import com.dwe.dealwitheat.commons.Response;

public class UserResponse extends Response {

    private UserEntity response;

    public UserEntity getResponse() {
        return response;
    }

    public void setResponse(UserEntity response) {
        this.response = response;
    }

}
