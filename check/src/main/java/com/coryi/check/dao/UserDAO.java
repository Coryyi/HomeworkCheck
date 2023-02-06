package com.coryi.check.dao;

import com.coryi.check.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

   /* User addUser(String username,String password);

    User changeCover(String url);*/
}
