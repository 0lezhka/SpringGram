package com.kopylchak.dao.implementation;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.UserProfileDAO;
import com.kopylchak.exceptions.InvalidSignInDataException;
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
            session.createQuery("delete from userProfile where nickname=:nickname").
                    setParameter("nickname", userProfile.getNickname()).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean userExists(UserProfile userProfile) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where email=:email and password=:password").
                    setParameter("email", userProfile.getEmail()).
                    setParameter("password", userProfile.getPassword()).
                    list().size() == 1;
        }
    }

    public boolean isEmailBusy(String email){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where email=:email").setParameter("email", email)
                    .list().size() == 1;
        }
    }

    public boolean isPasswordBusy(String password){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where password=:password").setParameter("password", password)
                    .list().size() == 1;
        }
    }

    public boolean isNicknameBusy(String nickname){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where nickname=:nickname")
                    .setParameter("nickname", nickname).list().size() == 1;
        }
    }
}
