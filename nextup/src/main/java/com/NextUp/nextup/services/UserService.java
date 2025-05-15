package com.NextUp.nextup.services;

import org.springframework.stereotype.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.NextUp.nextup.model.User;
import com.NextUp.nextup.repository.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}

