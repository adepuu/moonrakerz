package com.adepuu.moonrakerz.user.controller;

import com.adepuu.moonrakerz.responses.Response;
import com.adepuu.moonrakerz.user.dto.RegisterRequestDto;
import com.adepuu.moonrakerz.user.dto.RegisterResponseDto;
import com.adepuu.moonrakerz.user.entity.User;
import com.adepuu.moonrakerz.user.svc.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{email}")
    public User profile(@PathVariable  String email) {
        return userService.profile(email);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto req) {
        return Response.success("Register success", userService.register(req));
    }

    @GetMapping("/count/{currencyId}")
    public ResponseEntity<?> countUserWithTheSameCurrencyId(@PathVariable int currencyId) {
        return Response.success("Get total users success", userService.countUserWithTheSameCurrencyId(currencyId));
    }
}
