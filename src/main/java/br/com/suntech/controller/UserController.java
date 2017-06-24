package br.com.suntech.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.suntech.domain.IUser;
import br.com.suntech.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/users", method=RequestMethod.GET)
@CrossOrigin(origins = {"http://localhost:3001", "https://suntech-front.herokuapp.com"})
@Api(value = "Usuários")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Retorna todos os usuários", response = IUser.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Usuários retornados com sucesso.", response = IUser.class, responseContainer = "List"),
	})
	public ResponseEntity<String> users() {
		List<? extends IUser> listUsers = this.userService.getAllUsers();
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(params = "name")
	@ApiOperation(value = "Retorna os usuários pelo nome.", produces = "application/json;charset=UTF-8", response = IUser.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Usuários retornados com sucesso.", response = IUser.class, responseContainer = "List"),
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "name", value = "Nome do usuário", paramType = "query", dataType = "string")
	  })
	public ResponseEntity<String> usersByName(String name) {
		List<? extends IUser> listUsers = this.userService.findByName(name);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(params = "email")
	@ApiOperation(value = "Retorna os usuários pelo email", produces = "application/json;charset=UTF-8", response = IUser.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Usuários retornados com sucesso.", response = IUser.class, responseContainer = "List"),
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "email", value = "Email do usuário", paramType = "query", dataType = "string")
	  })
	public ResponseEntity<String> usersByEmail(String email) {
		List<? extends IUser> listUsers = this.userService.findByEmail(email);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@RequestMapping(params = "username")
	@ApiOperation(value = "Retorna os usuários pelo username", produces = "application/json;charset=UTF-8", response = IUser.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Usuários retornados com sucesso.", response = IUser.class, responseContainer = "List"),
	})
	@ApiImplicitParams({
	    @ApiImplicitParam(name = "username", value = "Username do usuário", paramType = "query", dataType = "string")
	  })
	public ResponseEntity<String> usersByUsername(String username) {
		List<? extends IUser> listUsers = this.userService.findByUsername(username);
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.getJson(listUsers), HttpStatus.OK);
	}
	
	private String getJson(List<? extends IUser> listUsers) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
		return gson.toJson(listUsers);
	}
}