package com.adepuu.moonrakerz.user.repo;

import com.adepuu.moonrakerz.user.dto.TotalUserCountDto;
import com.adepuu.moonrakerz.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    @Query("SELECT COUNT(u) as totalUsers FROM User u WHERE u.currencyId = :currencyId ")
    TotalUserCountDto countUserWithTheSameCurrencyId(int currencyId);
}
