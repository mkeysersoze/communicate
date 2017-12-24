package com.tecky.communicate.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tecky.common.service.GenericService;
import com.tecky.communicate.entity.User;

/**
 * @author mekysersoze
 *
 */
public interface UserService extends GenericService<User>, UserDetailsService {

}
