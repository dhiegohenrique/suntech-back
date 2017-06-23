package br.com.suntech.domain;

import java.io.Serializable;
import java.util.Date;

public interface IUser extends Serializable{
	
	public Integer getId();

	public String getUsername();
	public String getPassword();
	public String getName();
	public String getFilterName();
	public String getSurname();
	public String getEmail();
	public String getPhone();

	public boolean isEnabled();

	public Date getRegisterDate();
}