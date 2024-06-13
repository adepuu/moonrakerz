package com.adepuu.moonrakerz.user.dto;

import com.adepuu.moonrakerz.user.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequestDto {
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Min(1)
    private int currencyId;

    public User toEntity() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setCurrencyId(currencyId);
        return user;
    }
}
