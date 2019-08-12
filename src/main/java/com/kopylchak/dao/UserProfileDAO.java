package com.kopylchak.dao;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.exceptions.SignUpDataIsBusyException;

public interface UserProfileDAO {
    void addUser(UserProfile userProfile) throws SignUpDataIsBusyException;
    void deleteUser(UserProfile userProfile);
    boolean userExists(UserProfile userProfile);
}
