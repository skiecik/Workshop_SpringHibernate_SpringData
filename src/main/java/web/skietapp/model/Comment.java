package web.skietapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@OneToOne
	private User user;
	@ManyToOne
	private Skieet skieet;
	private Timestamp created;
	private String text;

	public Comment() {
	}

	public Comment(long id, User user, Skieet skiet, Timestamp created, String text) {
		this.id = id;
		this.user = user;
		this.skieet = skiet;
		this.created = created;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skieet getSkieet() {
		return skieet;
	}

	public void setSkieet(Skieet skiet) {
		this.skieet = skiet;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
