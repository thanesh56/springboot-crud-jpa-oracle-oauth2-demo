package com.gl.springbootcrudjpaoracledemo.dao;

import com.gl.springbootcrudjpaoracledemo.model.Client;

import java.util.Optional;

public interface ClientDao {
     void saveClient(Client client);
    Optional<Client> getClientByName(String clientName);
}
