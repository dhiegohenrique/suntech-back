package br.com.suntech.dto;

import java.util.Date;

import br.com.suntech.domain.IUser;

public class UserDTO implements IUser {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String phone;
	
	private boolean enabled;
	
	private Date registerDate;

    public UserDTO(IUser iUser) {
        this.username = iUser.getUsername();
        this.name = iUser.getName();
        this.surname = iUser.getSurname();
        this.email = iUser.getEmail();
        this.id = iUser.getId();
        this.enabled = iUser.isEnabled();
        this.registerDate = iUser.getRegisterDate();
        this.password = iUser.getPassword();
        this.phone = iUser.getPhone();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}