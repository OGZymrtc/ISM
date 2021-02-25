package com.ogzymrtc.ism.service;

import org.springframework.data.domain.Pageable;

import com.ogzymrtc.ism.dto.UserDto;
import com.ogzymrtc.ism.util.TPage;

public interface UserService {
	UserDto save(UserDto user);

    UserDto getById(Long id);

    TPage<UserDto> getAllPageable(Pageable pageable);

    UserDto getByUsername(String username);
}
