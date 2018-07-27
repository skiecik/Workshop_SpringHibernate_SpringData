package web.skietapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.skietapp.model.User;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public String getRegistry(Model model) {
		model.addAttribute("user", new User());
		return "registry";
	}
	
	@PostMapping
	public String registerUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "registry";
		} else {
			userRepository.save(user);
			return "redirect:/";
		}
	}
}
