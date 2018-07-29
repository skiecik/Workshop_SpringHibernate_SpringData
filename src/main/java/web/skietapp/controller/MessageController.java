package web.skietapp.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.skietapp.model.Message;
import web.skietapp.model.User;
import web.skietapp.repository.MessageRepository;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	MessageRepository messageRepository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String getMessages(Model model, HttpSession sess) {
		User user = (User) sess.getAttribute("logged");
		List<Message> messages = messageRepository.findAllByRecieverIdOrderBySendDesc(user.getId());
		model.addAttribute("messages", messages);
		return "recievedMessages";
	}
	
	@GetMapping("/send/{id}")
	public String message(Model model, @PathVariable long id) {
		User receiver = userRepository.getOne(id);
		model.addAttribute("receiver", receiver);
		return "messageSend";
	}
	
	@PostMapping("/send/{id}")
	public String sendMessage(HttpSession sess, @RequestParam String text, @PathVariable long id) {
		Message message = new Message();
		message.setSender((User) sess.getAttribute("logged"));
		message.setReciever(userRepository.getOne(id));
		message.setText(text);
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		message.setSend(time);
		messageRepository.save(message);
		return "redirect:/messages";
	}
}
