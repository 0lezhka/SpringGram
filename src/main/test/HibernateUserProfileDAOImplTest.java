import com.kopylchak.beans.UserProfile;
import com.kopylchak.dao.implementation.HibernateUserProfileDAOImpl;
import com.kopylchak.exceptions.SignUpDataIsBusyException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HibernateUserProfileDAOImplTest{
    private HibernateUserProfileDAOImpl dao;
    private SessionFactory factory;
    private UserProfile testUser;

    public HibernateUserProfileDAOImplTest() {
        dao = new HibernateUserProfileDAOImpl();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        testUser = new UserProfile("email", "password", "nickname", "123456");
    }

    @Test
    public void addUser() throws SignUpDataIsBusyException {
        dao.addUser(testUser);

        UserProfile actual = null;

        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Query<UserProfile> query = session.createQuery("from userProfile where email=:email and password=:password " +
                    "and nickname=:nickname and phone=:phone", UserProfile.class);

            query.setParameter("email", testUser.getEmail()).
                    setParameter("password", testUser.getPassword()).
                    setParameter("nickname", testUser.getNickname()).
                    setParameter("phone", testUser.getPhone());

            actual = query.getSingleResult();

            Assertions.assertTrue(actual.getEmail().equals(testUser.getEmail()) &&
                    actual.getPassword().equals(testUser.getPassword()) &&
                    actual.getPhone().equals(testUser.getPhone()) &&
                    actual.getNickname().equals(testUser.getNickname()));
        }
    }

    @Test
    public void addExistingUser(){
        try(Session session = factory.openSession()){
            session.beginTransaction();

            session.persist(testUser);

            session.getTransaction().commit();
        }

        try{
            dao.addUser(testUser);
            Assertions.fail();
        }catch (SignUpDataIsBusyException e){
            Assertions.assertTrue(e.isEmilBusy() && e.isPasswordBusy() && e.isNicknameBusy());
        }

//        Assertions.assertThrows(SignUpDataIsBusyException.class, ()-> dao.addUser(testUser));
    }

    @Test
    public void deleteUser(){
        addTestUser();

        boolean result;
        try(Session session = factory.openSession()){
            session.beginTransaction();

            dao.deleteUser(testUser);
            result = session.get(UserProfile.class, "nickname") == null;

            session.getTransaction().commit();
        }

        Assertions.assertTrue(result);
    }

    @Test
    public void userExists(){
        if(dao.userExists(testUser)){
            Assertions.fail();
        }
        addTestUser();

        Assertions.assertTrue(dao.userExists(testUser));
    }


    public void addTestUser(){
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.persist(testUser);
            session.getTransaction().commit();
        }
    }

    @AfterEach
    public void removeTestUser(){
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            session.createQuery("delete from userProfile where nickname=" + testUser.getNickname()).executeUpdate();
            session.getTransaction().commit();
        }
    }

}
