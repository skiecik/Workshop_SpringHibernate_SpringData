package web.skietapp.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.skietapp.model.User;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/")
@SessionAttributes({"logged"})
public class LoginController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String getLog() {
		return "login";
	}
	
	@PostMapping
	public String logIn(@RequestParam String email, @RequestParam String password, Model model) {
		try {
		User user = userRepository.findByEmail(email);
		if (BCrypt.checkpw(password, user.getPassword())) {
			model.addAttribute("logged", user);
			return "redirect:/start";
		}
		} catch (NullPointerException e) {
		}
		return "login";			
	}
}
