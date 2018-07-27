package web.skietapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.mindrot.jbcrypt.BCrypt;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String userName;
	@NotBlank
	@Size(min=6, message="Password must have more than 6 letters")
	private String password;
	@NotBlank
	private String enabled;
	@Column(unique=true)
	@Email
	private String email;

	public User() {
	}

	public User(long id, @NotBlank String userName,
			@NotBlank @Size(min = 6, message = "Password must have more than 6 letters") String password,
			@NotBlank String enabled, @Email String email) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
