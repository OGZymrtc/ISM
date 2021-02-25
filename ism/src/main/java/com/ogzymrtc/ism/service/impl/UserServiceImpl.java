package com.ogzymrtc.ism.service.impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ogzymrtc.ism.dto.UserDto;
import com.ogzymrtc.ism.entity.User;
import com.ogzymrtc.ism.repository.UserRepository;
import com.ogzymrtc.ism.service.UserService;
import com.ogzymrtc.ism.util.TPage;

@Service
public class UserServiceImpl implements UserService{
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto save(UserDto user) {
		User s = modelMapper.map(user, User.class);
		s = userRepository.save(s);
		user.setId(s.getId());
		return user;
	}

	@Override
	public UserDto getById(Long id) {
		User u = userRepository.getOne(id);
		return modelMapper.map(u, UserDto.class);
	}

	@Override
	public TPage<UserDto> getAllPageable(Pageable pageable) {
		Page<User> page = userRepository.findAll(pageable);
		TPage<UserDto> response = new TPage<UserDto>();
		response.setStat(page, Arrays.asList(modelMapper.map(page.getContent(), UserDto[].class)));
		return response;
	}

	@Override
	public UserDto getByUsername(String username) {
		User u = userRepository.findByUsername(username);
		return modelMapper.map(u, UserDto.class);
	}
}
