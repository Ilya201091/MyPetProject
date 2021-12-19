package com.ilya.test.mydemoproject.service;

import com.ilya.test.mydemoproject.entities.User;
import com.ilya.test.mydemoproject.exception.LoginExistsException;
import com.ilya.test.mydemoproject.exception.NotIdUserException;
import com.ilya.test.mydemoproject.exception.NotNameUserException;
import com.ilya.test.mydemoproject.repository.UserRep;
import org.springframework.stereotype.Service;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */

@Service
public class UserService {

    private UserRep userRep;

    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    public User getUserByName(String userName) throws NotNameUserException {
        User user = userRep.findByUserName(userName);
        if(user == null) {
            throw new NotNameUserException("Данный логин " + userName + " отсутствует" );
        }
        return user;
    }

    public User register(User user) throws LoginExistsException {
        if(userRep.findByUserName(user.getUserName()) != null) {
            throw new LoginExistsException("Пользователь: {} уже существует",user.getUserName());
        }
        userRep.save(user);
        return user;
    }

    public User getById(Long id) throws NotIdUserException {
        User user = userRep.findById(id).get();
        if(user == null) {
            throw new NotIdUserException("Пользователь с id: {} отсутствует", id);
        }
        return user;
    }






}
