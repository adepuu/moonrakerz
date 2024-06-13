package com.adepuu.moonrakerz.user.svc;

import com.adepuu.moonrakerz.user.dto.RegisterRequestDto;
import com.adepuu.moonrakerz.user.dto.RegisterResponseDto;
import com.adepuu.moonrakerz.user.entity.User;

public interface UserService {
    RegisterResponseDto register(RegisterRequestDto req);
    User profile(String email);
    int countUserWithTheSameCurrencyId(int currencyId);
}
