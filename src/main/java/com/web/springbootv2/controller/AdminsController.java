package com.web.springbootv2.controller;

import com.web.springbootv2.model.Role;
import com.web.springbootv2.model.User;
import com.web.springbootv2.service.RoleService;
import com.web.springbootv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminsController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminsController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/index";
    }

    // С помощью аннотации @PathVariable, id извлечется из URL
    // и положится в переменную Long id, с которой мы уже сможем работать внутри метода
    @GetMapping("/{id}/user_info")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user_info";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("newUser") User user, Model model) {
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin/new_user";
    }

    // @ModelAttribute создает новый объект класса User, добавляет значения,
    // которые пришли POST запросом с формы из new_user, в поля объекта с помощью сеттеров
    // и добавляет созданный объект в модель через model.addAttribute()
    @PostMapping()
    public String addUser(@ModelAttribute("newUser") User user,
                          @RequestParam String[] setOfRoles) {

        Set<Role> roles = roleService.checkRoles(setOfRoles);
        user.setRoles(roles);

        userService.saveUser(user);

        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
            model.addAttribute("existingUser", userService.getUserById(id));
            model.addAttribute("allRoles", roleService.getAllRoles());
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("existingUser") User user,
                             @PathVariable("id") Long id,
                             @RequestParam String[] setOfRoles) {

        Set<Role> roles = roleService.checkRoles(setOfRoles);
        user.setRoles(roles);

        userService.updateUser(id, user);

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }
}