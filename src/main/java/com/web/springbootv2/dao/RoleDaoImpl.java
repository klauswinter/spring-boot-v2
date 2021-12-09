package com.web.springbootv2.dao;

import com.web.springbootv2.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveRole(Role role) {
        em.persist(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return em.createQuery("from Role where name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return em.find(Role.class, id);
    }


    @Override
    public List<Role> getAllRoles() {
        return em.createQuery("from Role", Role.class).getResultList();
    }
}
