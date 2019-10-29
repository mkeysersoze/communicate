package com.tecky.communicate.service.impl;

import com.tecky.common.repository.GenericRepository;
import com.tecky.common.service.impl.GenericServiceImpl;
import com.tecky.communicate.entity.User;
import com.tecky.communicate.repository.UserRepository;
import com.tecky.communicate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mekysersoze
 */
@Service("userServiceImpl")
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Username not found");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), getAuthorities(user.getRole().toString()));
    }

    private List<GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    protected GenericRepository<User> getMainRepository() {
        return userRepository;
    }
}
