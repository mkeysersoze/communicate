package com.tecky.communicate.repository;

import com.tecky.common.repository.GenericRepository;
import com.tecky.communicate.entity.User;

/**
 * @author mekysersoze
 */
public interface UserRepository extends GenericRepository<User> {

    User findByUsername(String username);
}
