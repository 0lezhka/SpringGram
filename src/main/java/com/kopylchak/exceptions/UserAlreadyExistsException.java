package com.kopylchak.exceptions;

import com.kopylchak.beans.UserProfile;

public class UserAlreadyExistsException extends UserProfileException {


    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
