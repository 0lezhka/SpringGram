package com.kopylchak.beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chat {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private List<Message> messages;

    public Chat() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
