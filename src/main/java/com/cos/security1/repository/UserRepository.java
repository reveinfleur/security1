package com.cos.security1.repository;

import com.cos.security1.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    public UserData findByUsername(String username);
}
