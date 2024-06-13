package com.adepuu.moonrakerz.auth.service.impl;

import com.adepuu.moonrakerz.auth.service.entity.UserAuth;
import com.adepuu.moonrakerz.user.entity.User;
import com.adepuu.moonrakerz.user.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User existingUser = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var userAuth = new UserAuth();
        userAuth.setEmail(existingUser.getEmail());
        userAuth.setPassword(existingUser.getPassword());
        return userAuth;
    }
}
