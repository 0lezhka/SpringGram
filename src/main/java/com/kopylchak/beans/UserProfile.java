package com.kopylchak.beans;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
@Entity(name = "userProfile")
public class UserProfile {
    @Id
    private String nickname;
    private String email;
    private String phone;
    private String password;

    public UserProfile() {
    }

    public UserProfile(String email, String password, String nickname, String phone) {
        this.email = email;
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

