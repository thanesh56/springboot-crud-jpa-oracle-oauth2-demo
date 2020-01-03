package com.gl.springbootcrudjpaoracledemo.dao.impl;

import com.gl.springbootcrudjpaoracledemo.dao.UserDao;
import com.gl.springbootcrudjpaoracledemo.exception.UserNotFoundException;
import com.gl.springbootcrudjpaoracledemo.model.User;
import com.gl.springbootcrudjpaoracledemo.repository.UserRepository;
import com.gl.springbootcrudjpaoracledemo.vo.GeneralDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserByEmail(String email) {
        log.debug("Returning User  by email from DAO ");
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> findAll() {
        log.debug("Returning User(s) from DAO");
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        log.debug("Returning User  by id from DAO ");
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User of this Id: "+id+" Not Found"));
    }

    @Override
    public User save(User newUser) {
        log.debug("Saving new User  to DAO ");
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(GeneralDetailVO generalDetailVO, Long userId) {
        log.debug("Updating User from DAO");
        User user = findById(userId);
        user.setName(generalDetailVO.getName());
        user.setPhoneNo(generalDetailVO.getPhoneNo());
        user.setEmail(generalDetailVO.getEmail());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        log.debug("Deleting User from DAO");
        userRepository.delete(user);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Removing User by id from DAO ");
        userRepository.deleteById(id);

    }
}
