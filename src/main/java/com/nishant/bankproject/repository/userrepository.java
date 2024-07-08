package com.nishant.bankproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.bankproject.entity.user;

public interface userrepository extends JpaRepository<user,Long> {
     Boolean existsByEmail(String email);
}
