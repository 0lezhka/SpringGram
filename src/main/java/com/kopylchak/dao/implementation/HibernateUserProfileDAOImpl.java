package com.kopylchak.dao.implementation;

import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.UserProfileDAO;
import com.kopylchak.exceptions.SignUpDataIsBusyException;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component("hibernateUserProfileDAOImpl")
public class HibernateUserProfileDAOImpl extends HibernateDAOImpl implements UserProfileDAO {
    @Override
    public void addUser(UserProfile userProfile) throws SignUpDataIsBusyException{
        SignUpDataIsBusyException e = new SignUpDataIsBusyException(isEmailBusy(userProfile.getEmail()),
                isPasswordBusy(userProfile.getPassword()), isNicknameBusy(userProfile.getNickname()));

        if(e.isDataBusy()){
            throw e;
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

    private boolean isEmailBusy(String email){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where email=:email").setParameter("email", email)
                    .list().size() == 1;
        }
    }

    private boolean isPasswordBusy(String password){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where password=:password").setParameter("password", password)
                    .list().size() == 1;
        }
    }

    private boolean isNicknameBusy(String nickname){
        try(Session session = factory.openSession()){
            session.beginTransaction();
            return session.createQuery("from userProfile where nickname=:nickname")
                    .setParameter("nickname", nickname).list().size() == 1;
        }
    }
}
