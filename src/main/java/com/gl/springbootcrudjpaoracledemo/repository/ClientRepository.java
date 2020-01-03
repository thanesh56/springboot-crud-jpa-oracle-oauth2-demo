package com.gl.springbootcrudjpaoracledemo.repository;


import com.gl.springbootcrudjpaoracledemo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Client repository for CRUD operations.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
    Optional<Client> findByUsername(String username);
}
