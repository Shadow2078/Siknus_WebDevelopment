package com.example.siknus_ed_tech_system.Service;

import com.example.siknus_ed_tech_system.Entity.User;
import com.example.siknus_ed_tech_system.Pojo.UserPojo;

import java.util.*;

public interface UserService {
    UserPojo save(UserPojo userPojo);
    User findByEmail(String email);
    List<User> findAll();

}
