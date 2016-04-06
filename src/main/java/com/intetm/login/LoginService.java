package com.intetm.login;

import com.intetm.db.dao.UserDao;
import com.intetm.db.entity.Authority;
import com.intetm.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public User createUser(String userName, String password, Authority authority) throws UserExistsException {
        if (userDao.isUserExist(userName)) {
            throw new UserExistsException(userName);
        }
        String hash = encoder.encode(password);
        User user = new User(userName, hash, authority);
        userDao.save(user);
        return user;
    }

    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        userDao.findAll().forEach(result::add);
        return result;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public PasswordEncoder getEncoder() {
        return encoder;
    }

    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
}
