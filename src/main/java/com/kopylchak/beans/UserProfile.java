package com.kopylchak.beans;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity(name = "userProfile")
public class UserProfile {
    @Id
    private String nickName;
    private String email;
    private String phone;

    public UserProfile() {
    }

    public UserProfile(String email, String nickName, String phone) {
        this.email = email;
        this.nickName = nickName;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

