package br.com.suntech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.suntech.domain.IUser;
import br.com.suntech.service.UserService;

@RestController
@RequestMapping(value="/users", method=RequestMethod.GET)
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private Gson gson;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @CrossOrigin(origins = "http://localhost:8090")
//    @ApiOperation(value = "User finding GET API")
	public ResponseEntity<String> users() {
		List<? extends IUser> listUsers = this.userService.getAllUsers();
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//  @CrossOrigin(origins = "http://localhost:8090")
//  @ApiOperation(value = "User finding GET API")
	@RequestMapping(params = "name")
	public ResponseEntity<String> usersByName(String name) {
		List<? extends IUser> listUsers = this.userService.findByName(name);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//  @CrossOrigin(origins = "http://localhost:8090")
//  @ApiOperation(value = "User finding GET API")
	@RequestMapping(params = "email")
	public ResponseEntity<String> usersByEmail(String email) {
		List<? extends IUser> listUsers = this.userService.findByEmail(email);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//  @CrossOrigin(origins = "http://localhost:8090")
//  @ApiOperation(value = "User finding GET API")
	@RequestMapping(params = "username")
	public ResponseEntity<String> usersByUsername(String username) {
		List<? extends IUser> listUsers = this.userService.findByUsername(username);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	private String getJson(List<? extends IUser> listUsers) {
		return this.gson.toJson(listUsers);
	}
}