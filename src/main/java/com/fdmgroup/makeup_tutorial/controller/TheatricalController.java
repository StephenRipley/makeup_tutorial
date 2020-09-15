package com.fdmgroup.makeup_tutorial.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.makeup_tutorial.model.TheatricalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.TheatricalService;

@Controller
public class TheatricalController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TheatricalController.class);

	@Autowired
	TheatricalService theatricalService;

	@Autowired
	ArtistService artistService;

	@GetMapping("AllTheatricalStyles")
	public ModelAndView allTheatricals() {
		return new ModelAndView("WEB-INF/allTheatricalStyles.jsp", "theatricalStyles", theatricalService.retrieveAll());
	}

	@GetMapping("DisplayTheatrical")
	public ModelAndView displayTheatrical(@RequestParam("id") Long id) {
		Optional<TheatricalStyle> theatricalStyle = theatricalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/displayTheatrical.jsp");
		modelAndView.addObject("theatricalstyle", theatricalStyle.get());
		return modelAndView;
	}
	@GetMapping("EditTheatrical")
	public ModelAndView editTheatrical(
			@RequestParam("id")Long id) {
		Optional<TheatricalStyle> theatricalStyle = theatricalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editTheatrical.jsp");
		modelAndView.addObject("theatricalstyle", theatricalStyle.get());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}
	@PostMapping("EditTheatricalSubmit")
	public ModelAndView editTheatricalSubmit(@ModelAttribute("theatricalstyle")TheatricalStyle theatricalStyle) {
		theatricalService.save(theatricalStyle);
		LOGGER.warn("Theatrical Style {}(id:{}) was updated at {}", theatricalStyle.getName(), theatricalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allTheatricalStyles.jsp", "theatricalStyles", theatricalService.retrieveAll());
	}
	@GetMapping("AddTheatrical")
	public ModelAndView addTheatrical() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addTheatrical.jsp");
		modelAndView.addObject("theatricalstyle", new TheatricalStyle());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}
	@PostMapping("AddTheatricalSubmit")
	public ModelAndView addTheatricalSubmit(@ModelAttribute("theatricalstyle")TheatricalStyle theatricalStyle) {
		theatricalService.save(theatricalStyle);
		LOGGER.warn("Theatrical Style {}(id:{}) was created at {}", theatricalStyle.getName(), theatricalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allTheatricalStyles.jsp", "theatricalStyles", theatricalService.retrieveAll());
	}
	
	@RequestMapping(value = "DeleteTheatrical", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteTheatrical(@RequestParam("id") Long id) {
		Optional<TheatricalStyle> theatricalStyle = theatricalService.findById(id);
		TheatricalStyle theatricalStyleName = theatricalService.findByName(theatricalStyle.get().getName());
		theatricalService.delete(theatricalStyleName);
		LOGGER.warn("Theatrical Style {}(id:{}) was deleted at {}", theatricalStyle.get().getName(), theatricalStyle.get().getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allTheatricalStyles.jsp", "theatricalStyles", theatricalService.retrieveAll());
	}

}
