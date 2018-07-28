package web.skietapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import web.skietapp.repository.SkieetRepository;

@Controller
@RequestMapping("/skieet")
public class SkieetController {

	@Autowired
	SkieetRepository skieetRepository;
	
	@GetMapping("/{id}")
	public String showSkieet(@PathVariable long id, Model model) {
		model.addAttribute("skieet", skieetRepository.getOne(id));
		return "skieetDetails";
	}
}
