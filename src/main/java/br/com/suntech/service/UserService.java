package br.com.suntech.service;

import java.util.List;

import br.com.suntech.domain.IUser;

public interface UserService {

	List<? extends IUser> getAllUsers();
	
	List<? extends IUser> findByEmail(String email);
	
	List<? extends IUser> findByUsername(String username);
	
	List<? extends IUser> findByName(String name);
}
