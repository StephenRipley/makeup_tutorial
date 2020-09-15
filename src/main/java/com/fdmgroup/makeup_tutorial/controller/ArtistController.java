package com.fdmgroup.makeup_tutorial.controller;

import java.time.LocalDateTime;
import java.util.EnumSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.StyleType;
import com.fdmgroup.makeup_tutorial.service.ArtistService;

@Controller
public class ArtistController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ArtistController.class);
	
	@Autowired
	private ArtistService artistService;
	
	@GetMapping("DisplayArtist")
	public ModelAndView displayArtist(
			@RequestParam("id")Long id) {
		Artist artist = artistService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/displayArtist.jsp");
		modelAndView.addObject("artist", artist);
		return modelAndView;
	}
	
	@GetMapping("AllArtists")
	public ModelAndView allArtists() {
		
		return new ModelAndView("WEB-INF/allArtists.jsp","artists", artistService.retrieveAll());
	}
	
	@GetMapping("EditArtist")
	public ModelAndView editArtist(
			@RequestParam("id")Long id) {
		Artist artist = artistService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editArtist.jsp");
		modelAndView.addObject("artist", artist);
		modelAndView.addObject("styleType", EnumSet.allOf(StyleType.class));
		return modelAndView;
	}
	
	@PostMapping("EditArtistSubmit")
	public ModelAndView editArtistSubmit(@ModelAttribute("artist")Artist artist) {
		artistService.save(artist);
		LOGGER.info("Artist {} details were updated at {}", artist.getEmail(), LocalDateTime.now());
		return new ModelAndView("WEB-INF/allArtists.jsp", "artists", artistService.retrieveAll());
	}
			

}
