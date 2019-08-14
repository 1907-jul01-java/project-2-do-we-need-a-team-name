package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.revature.data.User;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public User postUser(User user) {
        User newUser = user;
        getSession().persist("User", newUser);
        return newUser;
    }

    @SuppressWarnings("unchecked")
    public User findByUsername(String username) {
        List<User> users = new ArrayList<User>();

        users = getSession().createQuery("from User where username = :un").setParameter("un", username).list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public User authenticate(String username, String password) {
        User user = findByUsername(username);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}