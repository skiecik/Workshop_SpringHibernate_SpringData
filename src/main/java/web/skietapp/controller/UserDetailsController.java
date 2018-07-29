package web.skietapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import web.skietapp.model.Skieet;
import web.skietapp.model.User;
import web.skietapp.repository.SkieetRepository;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserDetailsController {

	@Autowired
	SkieetRepository skieetRepository;
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable long id, Model model) {
		List<Skieet> skieets = skieetRepository.findAllByUserIdOrderByDateDesc(id);
		User user = userRepository.getOne(id);
		model.addAttribute("skieets", skieets);
		model.addAttribute("user", user);		
		return "userDetails";
	}
//	@GetMapping("/skieet/{id}")
//	public String showDetails() {
//		return "redirect:/skieet/{id}";
//	}
	
//	@GetMapping("/messages/send/{id}")
//	public String redirToMessages() {
//		return "redirect:/messages/send/{id}";
//	}
}
