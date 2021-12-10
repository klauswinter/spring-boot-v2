package com.web.springbootv2.dao;

import com.web.springbootv2.model.Role;
import com.web.springbootv2.model.User;
import com.web.springbootv2.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
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

