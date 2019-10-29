package com.tecky.communicate.service;

import com.tecky.common.service.GenericService;
import com.tecky.communicate.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author mekysersoze
 */
public interface UserService extends GenericService<User>, UserDetailsService {

}
