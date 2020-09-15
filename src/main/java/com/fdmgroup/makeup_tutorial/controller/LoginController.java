package com.fdmgroup.makeup_tutorial.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.Subscriber;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.SubscriberService;

@Controller
public class LoginController {

	public final static String SESSION_ATTRIBUTE_SUBSCRIBER = "SUBSCRIBER";
	public final static String SESSION_ATTRIBUTE_ARTIST = "ARTIST";
	public final static String SESSION_ATTRIBUTE_SUBSCRIBERID = "SUBSCRIBERID";
	public final static String SESSION_ATTRIBUTE_ARTISTID = "ARTISTID";
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	SubscriberService subscriberService;

	@Autowired
	ArtistService artistService;

	@GetMapping("")
	public String home() {
		return "home.jsp";
	}

	@GetMapping("Login")
	public String login() {
		return "login.jsp";
	}

	@PostMapping("LoginSubmit")
	public ModelAndView loginSubmit(@ModelAttribute("subscriber") Subscriber subscriber,
			@ModelAttribute("artist") Artist artist, ModelMap model, HttpSession session) {
		Subscriber subscriberFromDatabase = subscriberService.findByEmailAndPassword(subscriber.getEmail(),
				subscriber.getPassword());
		Artist artistFromDatabase = artistService.findByEmailAndPassword(artist.getEmail(), artist.getPassword());
		if (subscriberFromDatabase == null || artistFromDatabase == null) {
			model.addAttribute("errorMessage", "Incorrect email or password");
		}
		if (subscriberFromDatabase != null) {
			session.setAttribute(SESSION_ATTRIBUTE_SUBSCRIBER, subscriberFromDatabase);
			Long subscriberId = subscriberService.findByEmail(subscriber.getEmail()).getSubscriberId();
			String subscriberName = subscriberService.findByEmail(subscriber.getEmail()).getFirstname();
			session.setAttribute(SESSION_ATTRIBUTE_SUBSCRIBERID, subscriberId);
			subscriber.setSubscriberId(subscriberId);
			subscriber.setFirstname(subscriberName);
			LOGGER.info("Subscriber {} logged in at {}", subscriber.getEmail(), LocalDateTime.now());
			return new ModelAndView("WEB-INF/subscriberMain.jsp");

		} else if (artistFromDatabase != null) {
			session.setAttribute(SESSION_ATTRIBUTE_ARTIST, artistFromDatabase);
			Long artistId = artistService.findByEmail(artist.getEmail()).getArtistId();
			String artistName = artistService.findByEmail(artist.getEmail()).getFirstname();
			session.setAttribute(SESSION_ATTRIBUTE_ARTISTID, artistId);
			artist.setArtistId(artistId);
			artist.setFirstname(artistName);
			LOGGER.info("Artist {} logged in at {}", artist.getEmail(), LocalDateTime.now());
			return new ModelAndView("WEB-INF/artistMain.jsp");
		}
		return new ModelAndView("login.jsp");
	}

	@GetMapping("Logout")
	public String logout(HttpSession session) {
		Subscriber subscriber = (Subscriber) session.getAttribute(SESSION_ATTRIBUTE_SUBSCRIBER);
		Artist artist = (Artist) session.getAttribute(SESSION_ATTRIBUTE_ARTIST);
		if (subscriber != null) {
			LOGGER.warn("Subscriber {} logged out at {}", subscriber.getEmail(), LocalDateTime.now());
		} else if (artist != null) {
			LOGGER.warn("Artist {} logged out at {}", artist.getEmail(), LocalDateTime.now());
		}
		session.invalidate();
		return "home.jsp";
	}

	@GetMapping("Main")
	public ModelAndView main(@ModelAttribute("subscriber") Subscriber subscriber, HttpSession session) {
		subscriber = (Subscriber) session.getAttribute(SESSION_ATTRIBUTE_SUBSCRIBER);
		Long subscriberId = subscriber.getSubscriberId();
		subscriber=subscriberService.findById(subscriberId);
		if (subscriber != null) {
			subscriber.getFirstname();
			ModelAndView modelAndView = new ModelAndView("WEB-INF/subscriberMain.jsp");
			modelAndView.addObject("subscriber", subscriber);
			return modelAndView;
		} else
			return new ModelAndView("WEB-INF/artistMain.jsp");
	}

}
