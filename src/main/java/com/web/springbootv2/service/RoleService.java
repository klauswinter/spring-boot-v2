package com.web.springbootv2.service;


import com.web.springbootv2.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void saveRole(Role role);

    Role getRoleById(Long id);

    Role getRoleByName(String name);

    List<Role> getAllRoles();

    Set<Role> getSetOfRoles(String[] roles);
}
