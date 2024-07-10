package com.nishant.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.bankproject.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
     Boolean existsByEmail(String email);
     Boolean existsByAccountnumber(String accountnumber);
     User findByAccountnumber(String accountnumber);
}
