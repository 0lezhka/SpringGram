package com.kopylchak.dao.implementation;

import com.kopylchak.beans.Chat;
import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.ChatDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateChatDAOImpl extends HibernateDAOImpl implements ChatDAO {
    @Override
    public void addChat(Chat chat) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.persist(chat);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteChat(Chat chat) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.createQuery("delete from Chat where id=:id").setParameter("id", chat.getId()).executeUpdate();
            session.getTransaction().commit();
        }
    }
}
