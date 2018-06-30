package com.yummy.user.model;

public class RequestUserParameters {

    private String email;
    private String password;

    public RequestUserParameters() {
    }

    public RequestUserParameters(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
