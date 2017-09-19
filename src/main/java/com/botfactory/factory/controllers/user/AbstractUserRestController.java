package com.botfactory.factory.controllers.user;

import com.botfactory.factory.model.User;
import com.botfactory.factory.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

abstract public class AbstractUserRestController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService service;

    public List<User> getAll(){
        log.info("getAll");
        return service.getAll();
    }
}
