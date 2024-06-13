package com.adepuu.moonrakerz.user.svc.impl;

import com.adepuu.moonrakerz.user.dto.RegisterRequestDto;
import com.adepuu.moonrakerz.user.dto.RegisterResponseDto;
import com.adepuu.moonrakerz.user.entity.User;
import com.adepuu.moonrakerz.user.repo.UserRepository;
import com.adepuu.moonrakerz.user.svc.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterResponseDto register(RegisterRequestDto req) {
        var newUser = userRepository.save(req.toEntity());
        var response = new RegisterResponseDto();
        response.setEmail(newUser.getEmail());
        response.setCurrencyId(newUser.getCurrencyId());
        return response;
    }

    @Override
    public User profile(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public int countUserWithTheSameCurrencyId(int currencyId) {
        return userRepository.countUserWithTheSameCurrencyId(currencyId).getTotalUsers();
    }
}
