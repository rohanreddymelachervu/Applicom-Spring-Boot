package com.Applicom.rest.repository;

import com.Applicom.rest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String name);
    boolean existsByName(String name);
}
