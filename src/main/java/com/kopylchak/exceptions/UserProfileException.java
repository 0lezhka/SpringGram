package com.kopylchak.exceptions;

import com.kopylchak.beans.UserProfile;

public class UserProfileException extends RuntimeException {
    public UserProfileException(String msg){
        super(msg);
    }

    public UserProfileException() {
    }
}
