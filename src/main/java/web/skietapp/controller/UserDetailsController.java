package web.skietapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import web.skietapp.model.User;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserDetailsController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable long id, Model model) {
		User user = userRepository.getOne(id);
		model.addAttribute(user);
		return "userDetails";
	}
}
