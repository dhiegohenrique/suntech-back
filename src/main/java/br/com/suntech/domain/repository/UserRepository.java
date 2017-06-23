package br.com.suntech.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suntech.domain.IUser;
import br.com.suntech.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	List<IUser> findByEmail(String email);
	
	List<IUser> findByUsername(String username);
	
	List<IUser> findByName(String name);
}
