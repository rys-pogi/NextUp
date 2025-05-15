package com.NextUp.nextup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NextUp.nextup.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
