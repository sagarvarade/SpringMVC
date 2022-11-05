package com.MainApp.SpringMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.SpringMVC.domain.AppUser;
import com.MainApp.SpringMVC.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

}
