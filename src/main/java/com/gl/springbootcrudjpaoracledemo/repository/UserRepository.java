package com.gl.springbootcrudjpaoracledemo.repository;

import com.gl.springbootcrudjpaoracledemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

}
