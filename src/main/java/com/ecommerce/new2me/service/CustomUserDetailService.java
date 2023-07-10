package com.ecommerce.new2me.service;

import com.ecommerce.new2me.model.CustomUserDetails;
import com.ecommerce.new2me.model.User;
import com.ecommerce.new2me.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("User name not found"));
        return user.map(CustomUserDetails::new).get();
    }
}
