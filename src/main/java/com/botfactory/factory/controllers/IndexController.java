package com.botfactory.factory.controllers;

import com.botfactory.factory.service.UserService;
import com.botfactory.factory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/")
    String index() {
        return "index";
    }
}
