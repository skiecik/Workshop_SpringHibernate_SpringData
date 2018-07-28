package web.skietapp.controller;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.skietapp.model.Comment;
import web.skietapp.model.Skieet;
import web.skietapp.model.User;
import web.skietapp.repository.CommentRepository;
import web.skietapp.repository.SkieetRepository;

@Controller
@RequestMapping("/start")
public class MainPageController {

	@Autowired
	SkieetRepository skieetRepository;
	@Autowired
	CommentRepository commentRepository;
	
	@GetMapping
	public String startPage(Model model) {
		List<Skieet> list = skieetRepository.findAll();
		Collections.reverse(list);
		model.addAttribute("skieets", list);
		model.addAttribute("skieet", new Skieet());
		return "mainPage";
	}
	
	@PostMapping("/add/skieet")
	public String addSkieet(@ModelAttribute Skieet skieet, HttpSession sess) {
		User user = (User) sess.getAttribute("logged");
		skieet.setUser(user);
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		skieet.setDate(time);
		skieetRepository.save(skieet);
		return "redirect:/start";
	}
	
	@PostMapping("/add/comment")
	public String addComment(@RequestParam String commentText, @RequestParam long commentSkieetId, HttpSession sess) {
		User user = (User) sess.getAttribute("logged");
		Comment comment = new Comment();
		comment.setUser(user);
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		comment.setCreated(time);
		comment.setText(commentText);
		comment.setSkieet(skieetRepository.getOne(commentSkieetId));
		commentRepository.save(comment);
		return "redirect:/start";
	}
}
