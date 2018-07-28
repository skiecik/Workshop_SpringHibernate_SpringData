package web.skietapp.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private User sender;
	@ManyToOne
	private User reciever;
	private String text;
	private String opend;
	private Timestamp send;
	public Message() {
	}
	public Message(long id, User sender, User reciever, String text, String opend, Timestamp send) {
		super();
		this.id = id;
		this.sender = sender;
		this.reciever = reciever;
		this.text = text;
		this.opend = opend;
		this.send = send;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReciever() {
		return reciever;
	}
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getOpend() {
		return opend;
	}
	public void setOpend(String opend) {
		this.opend = opend;
	}
	public Timestamp getSend() {
		return send;
	}
	public void setSend(Timestamp send) {
		this.send = send;
	}
	
}
