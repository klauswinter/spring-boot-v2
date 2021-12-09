//package com.web.springbootv2.model;
//
//import com.web.springbootv2.service.UserService;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.util.Set;
//
//@Component
//@Transactional
//public class DbInit {
//
//    private final UserService userService;
//
//    public DbInit(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostConstruct
//    public void initUsers() {
//        User admin = new User();
//        admin.setName("admin");
//        admin.setLastName("admin");
//        admin.setAge(35);
//        admin.setEmail("admin@mail.ru");
//        admin.setPassword("admin");
//        admin.setRoles(Set.of(new Role("ROLE_ADMIN")));
//        userService.saveUser(admin);
//
//        User user = new User();
//        user.setName("user");
//        user.setLastName("user");
//        user.setAge(30);
//        user.setEmail("user@mail.ru");
//        user.setPassword("user");
//        user.setRoles(Set.of(new Role("ROLE_USER")));
//        userService.saveUser(user);
//    }
//}