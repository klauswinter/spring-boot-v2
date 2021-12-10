package com.web.springbootv2.dao;

import com.web.springbootv2.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getByName(String name) {
        return em.createQuery("from User where name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public void removeUserById(Long id) {
        em.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }
}

