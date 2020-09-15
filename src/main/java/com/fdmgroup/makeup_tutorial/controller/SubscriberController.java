package com.fdmgroup.makeup_tutorial.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.makeup_tutorial.model.Subscriber;
import com.fdmgroup.makeup_tutorial.service.SubscriberService;

@Controller
public class SubscriberController {

	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping("ViewProfile")
	public ModelAndView displaySubscriber(@RequestParam("id") Long subscriberId, HttpSession session) {
		Subscriber subscriber = subscriberService.findById(subscriberId);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/subscriberProfile.jsp");
		modelAndView.addObject("subscriber", subscriber);

		return modelAndView;
	}
	
	@GetMapping("EditProfile")
	public ModelAndView editProfile(
			@RequestParam("id")Long id) {
		Subscriber subscriber = subscriberService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editProfile.jsp");
		modelAndView.addObject("subscriber", subscriber);
		return modelAndView;
	}
	
	@PostMapping("EditProfileSubmit")
	public ModelAndView editProfileSubmit(@ModelAttribute("subscriber")Subscriber subscriber) {
		subscriberService.save(subscriber);
		return new ModelAndView("WEB-INF/subscriberProfile.jsp");
	}

}
