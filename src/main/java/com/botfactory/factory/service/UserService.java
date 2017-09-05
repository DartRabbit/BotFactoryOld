package com.botfactory.factory.service;

import com.botfactory.factory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

}