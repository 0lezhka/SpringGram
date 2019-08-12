package com.kopylchak.dao;

import com.kopylchak.beans.Chat;
import com.kopylchak.beans.UserProfile;

import java.util.List;

public interface ChatDAO {
    void addChat(Chat chat);
    void deleteChat(Chat chat);
}
