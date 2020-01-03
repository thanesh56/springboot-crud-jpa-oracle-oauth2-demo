package com.gl.springbootcrudjpaoracledemo.dao.impl;

import com.gl.springbootcrudjpaoracledemo.dao.ClientDao;
import com.gl.springbootcrudjpaoracledemo.model.Client;
import com.gl.springbootcrudjpaoracledemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientDaoImpl implements ClientDao {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void saveClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientRepository.save(client);

    }

    @Override
    public Optional<Client> getClientByName(String clientName) {
        return clientRepository.findByUsername(clientName);
    }
}
