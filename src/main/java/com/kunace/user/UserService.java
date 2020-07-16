package com.kunace.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public void addUser(User user) {
        userDao.save(user);
    }
    public Page<User> getUserByPage(Pageable pageable) {
        return userDao.findAll(pageable);
    }

}
