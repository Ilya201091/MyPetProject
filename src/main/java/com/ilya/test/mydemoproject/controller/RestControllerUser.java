package com.ilya.test.mydemoproject.controller;

import com.ilya.test.mydemoproject.dto.UserDto;
import com.ilya.test.mydemoproject.entities.User;
import com.ilya.test.mydemoproject.exception.LoginExistsException;
import com.ilya.test.mydemoproject.exception.NotIdUserException;
import com.ilya.test.mydemoproject.exception.NotNameUserException;
import com.ilya.test.mydemoproject.service.UserService;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RestControllerUser {

    private final UserService userService;
    private ModelMapper modelMapper;

    @Autowired
    public RestControllerUser(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public RestControllerUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping ()
    public ResponseEntity getUserByName(@RequestParam String name) throws NotNameUserException {
        try {
            User user = userService.getUserByName(name);
            log.info("IN getUserByName user: {} shown by username: {}", user,name);
            return ResponseEntity.ok().body(modelMapper.map(user, UserDto.class));
        } catch (NotNameUserException exception) {
            log.warn("IN getUserByName user: {} was not found", name);
            return ResponseEntity.badRequest().body(exception.getMessage());

        }

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        try {
            User userResult = userService.register(user);
            UserDto userDto = modelMapper.map(userResult,UserDto.class);
            log.info("IN register user: {} saved", userDto.getUserName());
            return ResponseEntity.ok().body(userDto);
        } catch (LoginExistsException e) {
            log.warn("IN register user: {} already exists",user.getUserName());
            return  ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception ex) {
            log.debug("IN register exception");
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    private ResponseEntity getById(@RequestParam Long id) {
        try {
            User user = userService.getById(id);
            log.info("IN getById user: {} was displayed", id);
            return ResponseEntity.ok().body(modelMapper.map(user,UserDto.class));
        }
        catch (NotIdUserException exception) {
            log.warn("IN getById user: {} missing", id);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        catch (Exception ex) {
            log.debug("IN getById exception");
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete() {
        return null;
        //TODO
    }

}
