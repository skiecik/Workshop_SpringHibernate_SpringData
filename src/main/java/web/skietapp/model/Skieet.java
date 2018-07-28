package web.skietapp.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skieet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(max = 140)
	@NotBlank
	private String text;
	private Timestamp date;
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "skieet", cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Skieet() {
	}

	public Skieet(long id, @Size(max = 140) @NotBlank String text, Timestamp date, User user) {
		this.id = id;
		this.text = text;
		this.date = date;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		Collections.reverse(comments);
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> fiveNewestComments() {
		List<Comment> fiveComments = new ArrayList<>();
		if (this.comments.size() > 5) {
			for (int i = 1; i < 6; i++) {
				fiveComments.add(this.comments.get(this.comments.size() - i));
			}
			return fiveComments;
		} else {
			Collections.reverse(comments);
			return this.comments;
		}
	}

}
