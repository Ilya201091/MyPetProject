package com.ilya.test.mydemoproject.service;

import com.ilya.test.mydemoproject.entities.User;
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
            throw new NotNameUserException("Данный {}" + userName + "отсутствует" );
        }
        return user;
    }






}
