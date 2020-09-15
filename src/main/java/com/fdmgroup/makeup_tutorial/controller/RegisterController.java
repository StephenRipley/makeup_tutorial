package com.fdmgroup.makeup_tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.Subscriber;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.SubscriberService;

@Controller
public class RegisterController {

	@Autowired
	SubscriberService subscriberService;

	@Autowired
	ArtistService artistService;

	@GetMapping("SubscriberRegister")
	public String subscriberregister() {
		return "subscriberregister.jsp";

	}

	@GetMapping("ArtistRegister")
	public String artistregister() {
		return "artistregister.jsp";
	}

	@PostMapping("SubscriberRegisterSubmit")
	public String registerSubmit(@ModelAttribute("subcriber") Subscriber subscriber,
			@ModelAttribute("artist") Artist artist, ModelMap model) {

		Artist artistFromDatabase = artistService.findByEmail(artist.getEmail());
		Subscriber subscriberFromDatabase = subscriberService.findByEmail(subscriber.getEmail());
		if (subscriberFromDatabase != null || artistFromDatabase != null) {
			model.addAttribute("errorMessage", "Email already registered, please enter a different email");
			return "subscriberregister.jsp";
		}
		subscriberService.save(subscriber);
		return "login.jsp";
	}

	@PostMapping("ArtistRegisterSubmit")
	public String artistRegisterSubmit(@ModelAttribute("artist") Artist artist,
			@ModelAttribute("subscriber") Subscriber user, ModelMap model) {

		Subscriber subscriberFromDatabase = subscriberService.findByEmail(user.getEmail());
		Artist artistFromDatabase = artistService.findByEmail(artist.getEmail());
		if (artistFromDatabase != null || subscriberFromDatabase != null) {
			model.addAttribute("errorMessage", "Email already registered, please enter a different email");
			return "artistregister.jsp";
		}
		artistService.save(artist);
		return "login.jsp";
	}
}
