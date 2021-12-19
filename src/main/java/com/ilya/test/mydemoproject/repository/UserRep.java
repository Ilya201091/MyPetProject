package com.ilya.test.mydemoproject.repository;

import com.ilya.test.mydemoproject.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

/**
 * @author Shaporto Ilya
 * @date 18.12.2021
 */

@Repository
public interface UserRep extends CrudRepository<User, Long> {

     User findByUserName(String name);
}
