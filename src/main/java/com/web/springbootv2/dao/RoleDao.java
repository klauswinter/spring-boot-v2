package com.web.springbootv2.dao;

import com.web.springbootv2.model.Role;

import java.util.List;

public interface RoleDao {

    void saveRole(Role role);

    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();
}
