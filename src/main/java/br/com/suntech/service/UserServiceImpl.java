package br.com.suntech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.suntech.domain.IUser;
import br.com.suntech.domain.repository.UserRepository;
import br.com.suntech.utils.FilterUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<? extends IUser> getAllUsers() {
		Sort sort = new Sort(Direction.ASC, "id");
		return this.userRepository.findAll(sort);
	}
	
	@Override
	public List<? extends IUser> findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public List<? extends IUser> findByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<? extends IUser> findByName(String name) {
		return this.userRepository.findByName(FilterUtils.getFilterLike(name));
	}
}