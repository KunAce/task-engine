package com.kunace.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(1,15);
        Page<User> page = userService.getUserByPage(pageRequest);
        System.out.println(page);
    }

    @GetMapping("/createUser")
    public void createUser() {
        User user = new User();
        user.setGender("Unknown");
        user.setEmail("default@default.com");
        user.setUsername("defaultUsername");
        user.setRealname("defaultRealname");
        user.setPassword("defaultPassword");
        userService.addUser(user);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/testUser")
    public User testUser() {
        User testUser = new User();
        testUser.setGender("testGender");
        testUser.setEmail("testUser@default.com");
        testUser.setUsername("testUsername");
        testUser.setRealname("testRealname");
        testUser.setPassword("testPassword");
        return testUser;
    }
}
