package com.practice.myhome.repository;

import com.practice.myhome.model.User;

import java.util.List;

public interface CustomizedUserRepository {
    List<User> findByUsernameCustom(String username);

    List<User> findByUsernameJdbc(String username);
}
