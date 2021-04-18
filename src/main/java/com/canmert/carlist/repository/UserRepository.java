package com.canmert.carlist.repository;

import java.util.Optional;

import com.canmert.carlist.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AdminRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}