package br.com.suntech;

import java.lang.reflect.Type;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.suntech.dto.UserDTO;

@Sql(scripts = {"/scripts/insertUsers.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"/scripts/deleteUsers.sql"}, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class UserControllerTest extends BaseTest {
	
    private Gson gson = new Gson();
    
    @Test
	@Rollback
	public void shouldBeReturnAllUsers() {
		this.setUrl(URL_USERS);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNotNull();
		Assertions.assertThat(listUsers).extracting("id").isNotNull();
	}
    
    @Test
	@Rollback
	public void shouldBeReturnUserByName() {
    	String name = "Dhiego";
		this.setUrl(URL_USERS + "?name=" + name);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNotNull();
		Assertions.assertThat(listUsers).extracting("name").contains(name);
	}
    
    @Test
	@Rollback
	public void shouldBeReturnStatus404WhenUserByNameNotFound() {
    	String name = "MEU_NomE";
		this.setUrl(URL_USERS + "?name=" + name);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNull();
	}
    
    @Test
	@Rollback
	public void shouldBeReturnUserByUsername() {
    	String username = "user1";
		this.setUrl(URL_USERS + "?username=" + username);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNotNull();
		Assertions.assertThat(listUsers).extracting("username").contains(username);
	}
    
    @Test
	@Rollback
	public void shouldBeReturnStatus404WhenUserByUsernameNotFound() {
    	String username = "RONALDO";
		this.setUrl(URL_USERS + "?username=" + username);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNull();
	}
    
    @Test
	@Rollback
	public void shouldBeReturnUserByEmail() {
    	String email = "dhiego.henrique@hotmail.com";
		this.setUrl(URL_USERS + "?email=" + email);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNotNull();
		Assertions.assertThat(listUsers).extracting("email").contains(email);
	}
    
    @Test
	@Rollback
	public void shouldBeReturnStatus404WhenUserByEmailNotFound() {
    	String email = "novoEmail@yahoo.com.br";
		this.setUrl(URL_USERS + "?email=" + email);
		
		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(this.url, String.class);
		Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());
		
		List<UserDTO> listUsers = this.fromJson(responseEntity);
		Assertions.assertThat(listUsers).isNull();
	}

	private List<UserDTO> fromJson(ResponseEntity<String> responseEntity) {
		Type type = new TypeToken<List<UserDTO>>(){}.getType();
		return this.gson.fromJson(responseEntity.getBody(), type);
	}
}