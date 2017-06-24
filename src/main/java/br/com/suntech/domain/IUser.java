package br.com.suntech.domain;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public interface IUser extends Serializable{
	
	@ApiModelProperty(example = "1")
	public Integer getId();

	@ApiModelProperty(example = "maria.silva")
	public String getUsername();
	
	@ApiModelProperty(example = "123qwe")
	public String getPassword();
	
	@ApiModelProperty(example = "Maria")
	public String getName();
	
	@ApiModelProperty(example = "Silva")
	public String getSurname();
	
	@ApiModelProperty(example = "maria@hotmail.com")
	public String getEmail();
	
	@ApiModelProperty(example = "48999996666")
	public String getPhone();
	
	public boolean isEnabled();

	public Date getRegisterDate();
}