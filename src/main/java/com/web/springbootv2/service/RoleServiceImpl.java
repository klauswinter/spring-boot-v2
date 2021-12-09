package com.web.springbootv2.service;

import com.web.springbootv2.dao.RoleDaoImpl;
import com.web.springbootv2.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleDaoImpl roleDao;

    @Autowired
    public void setRoleDao(RoleDaoImpl roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Set<Role> getSetOfRoles(String[] roles) {
        Set<Role> rolesSet = new HashSet<>();

        for (String role : roles) {
            rolesSet.add(roleDao.getRoleByName(role));
        }
        return rolesSet;
    }
}
