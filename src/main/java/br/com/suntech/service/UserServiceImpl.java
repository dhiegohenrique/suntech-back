package br.com.suntech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.suntech.domain.IUser;
import br.com.suntech.domain.User;
import br.com.suntech.domain.repository.UserRepository;

@Service
public class UserServiceImpl extends BaseService implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<? extends IUser> getAllUsers() {
		Sort sort = new Sort(Direction.ASC, "id");
		return this.userRepository.findAll(sort);
	}
	
	@Override
	public Page<User> getAllUsers(int page, int size) {
		return this.getAllUsers(page, size, "");
	}
	
	@Override
	public Page<User> getAllUsers(int page, int size, String... sortFields) {
		PageRequest pageRequest = this.getPageRequest(page, size, sortFields);
		return this.userRepository.findAll(pageRequest);
	}
	
	@Override
	public List<? extends IUser> findByEmail(String email) {
		if (email == null) {
			email = "";
		}
		
		return this.userRepository.findByEmail(email);
	}

	@Override
	public List<? extends IUser> findByUsername(String username) {
		if (username == null) {
			username = "";
		}
		
		return this.userRepository.findByUsername(username);
	}

	@Override
	public List<? extends IUser> findByName(String name) {
		if (name == null) {
			name = "";
		}
		
		return this.userRepository.findByName(name.toUpperCase());
	}
}