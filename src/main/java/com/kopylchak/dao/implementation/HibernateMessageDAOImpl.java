package com.kopylchak.dao.implementation;

import com.kopylchak.beans.Message;
import com.kopylchak.dao.MessageDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateMessageDAOImpl extends HibernateDAOImpl implements MessageDAO {
    @Override
    public void addMessage(Message message) {
        try(Session session = factory.openSession()){
            session.beginTransaction();

            session.persist(message);

            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteMessage(Message message) {
        try(Session session = factory.openSession()){
            session.beginTransaction();

            session.createQuery("delete from message where id=:id").setParameter("id", message.getId()).executeUpdate();

            session.getTransaction().commit();
        }
    }
}
