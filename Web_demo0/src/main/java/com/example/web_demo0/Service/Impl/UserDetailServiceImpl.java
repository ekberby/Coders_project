package com.example.web_demo0.Service.Impl;

import com.example.web_demo0.Model.Entity.User;
import com.example.web_demo0.Model.UserPrincipal;
import com.example.web_demo0.Repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        System.out.println(user.getUsername() +" want to login");
        return new UserPrincipal(user);
    }
}
