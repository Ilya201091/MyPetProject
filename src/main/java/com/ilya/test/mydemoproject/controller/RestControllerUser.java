package com.ilya.test.mydemoproject.controller;

import com.ilya.test.mydemoproject.entities.User;
import com.ilya.test.mydemoproject.exception.NotNameUserException;
import com.ilya.test.mydemoproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */

@RestController
@RequestMapping("/api")
public class RestControllerUser {

    private final UserService userService;

    public RestControllerUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/name")
    public User getUserByName(@RequestParam String name) throws NotNameUserException {
        User user = userService.getUserByName(name);
        return user;
    }
}
