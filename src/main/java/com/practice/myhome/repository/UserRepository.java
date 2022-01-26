package com.practice.myhome.repository;

import com.practice.myhome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
