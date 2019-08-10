package com.kopylchak.dao.implementation;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.UserProfileDAO;
import com.kopylchak.exceptions.UserAlreadyExistsException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Component;

@Component("hibernateUserProfileDAOImpl")
public class HibernateUserProfileDAOImpl implements UserProfileDAO {
    private SessionFactory factory;

    public HibernateUserProfileDAOImpl(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Override
    public void addUser(UserProfile userProfile) {
        if(userExists(userProfile)){
            throw new UserAlreadyExistsException();
        }

        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.persist(userProfile);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteUser(UserProfile userProfile) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.createQuery("delete from userProfile where nickName=:nickname").
                    setParameter("nickname", userProfile.getNickName()).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean userExists(UserProfile userProfile) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.get(UserProfile.class, userProfile.getNickName()) != null;
        }
    }
}
