package com.kopylchak.dao;

import com.kopylchak.beans.UserProfile;

public interface UserProfileDAO {
    void addUser(UserProfile userProfile);
    void deleteUser(UserProfile userProfile);
    boolean userExists(UserProfile userProfile);
}
