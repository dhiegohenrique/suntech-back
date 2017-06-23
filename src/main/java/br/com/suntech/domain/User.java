package br.com.suntech.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name="User.findByEmail", query="SELECT u FROM User u WHERE u.email = ?1 ORDER BY u.id"),
	@NamedQuery(name="User.findByUsername", query="SELECT u FROM User u WHERE u.username = ?1 ORDER BY u.id"),
	@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.filtername LIKE ?1 ORDER BY u.id")
})
public class User implements IUser {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	
	private String username;
	private String password;
	private String name;
	private String filtername;
	private String surname;
	private String email;
	private String phone;
	
	private boolean enabled;
	
	@Column(name = "registerdate")
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date registerDate;

	public Integer getId() {
		return this.id;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}

	@Override
	public String getFilterName() {
		return this.filtername;
	}
}