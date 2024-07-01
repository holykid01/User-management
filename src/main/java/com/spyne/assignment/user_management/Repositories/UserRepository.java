package com.spyne.assignment.user_management.Repositories;

import com.spyne.assignment.user_management.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByMobileNo(String mobileNo);
    Optional<User> findByName(String name);
}
