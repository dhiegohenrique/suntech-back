package br.com.suntech.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.suntech.domain.IUser;
import br.com.suntech.domain.User;

public interface UserService {

	List<? extends IUser> getAllUsers();
	
	List<? extends IUser> findByEmail(String email);
	
	List<? extends IUser> findByUsername(String username);
	
	List<? extends IUser> findByName(String name);

	Page<User> getAllUsers(int page, int size);

	Page<User> getAllUsers(int page, int size, String... sortFields);
}
