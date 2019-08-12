package com.kopylchak.dao;

import com.kopylchak.beans.Message;

public interface MessageDAO {
    void addMessage(Message message);
    void deleteMessage(Message message);
}
