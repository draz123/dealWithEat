package com.dwe.dealwitheat.user.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "batch.user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    private String name;
    private String surname;
    private String nickname;
    private String password;
    private String groupName;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String nickname, String password, String groupName, String email) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
