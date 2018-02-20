package com.dwe.dealwitheat.user.model;

import javax.persistence.*;

@Entity(name="user")
@Table(name = "user")
public class UserEntity {

    @Id
    private String email;
    private String password;
    private String groupName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity() {
    }

    public UserEntity(String password, String groupName, String email) {
        this.password = password;
        this.groupName = groupName;
        this.email = email;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
