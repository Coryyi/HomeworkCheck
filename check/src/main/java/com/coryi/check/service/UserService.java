package com.coryi.check.service;

import com.coryi.check.dao.UserDAO;
import com.coryi.check.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public boolean add(String username,String password) {
        User user = getByName(username);
        System.out.println(username);
        if(user == null){
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userDAO.save(user);
            return true;
        }else {
            return false;
        }
    }
}