package web.skietapp.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import web.skietapp.model.User;
import web.skietapp.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserControllerTest {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("test2")
	public String test2(Model model) {
		User user = userRepository.getOne(1l);
		System.out.println(user.getUserName());
		model.addAttribute("user", user);
		return "form";
	}
	
	@PostMapping("test2")
	@ResponseBody
	public String pTest2(@ModelAttribute User user) {
		//reset pass only, modify like:
		//userToModify = userRepository getOne(user.getId())
		//set modified fields and save to database
		return "" + BCrypt.checkpw("password", user.getPassword());
	}
}
