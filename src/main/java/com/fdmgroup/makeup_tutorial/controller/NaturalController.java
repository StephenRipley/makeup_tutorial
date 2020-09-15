package com.fdmgroup.makeup_tutorial.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.makeup_tutorial.model.NaturalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.NaturalService;

@Controller
public class NaturalController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(NaturalController.class);

	@Autowired
	NaturalService naturalService;

	@Autowired
	ArtistService artistService;

	@GetMapping("AllNaturalStyles")
	public ModelAndView allNaturals() {
		return new ModelAndView("WEB-INF/allNaturalStyles.jsp", "naturalStyles", naturalService.retrieveAll());
	}

	@GetMapping("DisplayNatural")
	public ModelAndView displayNatural(@RequestParam("id") Long id) {
		Optional<NaturalStyle> naturalStyle = naturalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/displayNatural.jsp");
		modelAndView.addObject("naturalstyle", naturalStyle.get());
		modelAndView.addObject("artist", artistService.retrieveAll());
		return modelAndView;
	}

	@GetMapping("EditNatural")
	public ModelAndView editNatural(@RequestParam("id") Long id) {
		Optional<NaturalStyle> naturalStyle = naturalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editNatural.jsp");
		modelAndView.addObject("naturalstyle", naturalStyle.get());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}

	@PostMapping("EditNaturalSubmit")
	public ModelAndView editNaturalSubmit(@ModelAttribute("naturalstyle") NaturalStyle naturalStyle, ModelMap model) {
		naturalService.save(naturalStyle);
		LOGGER.warn("Natural Style {}(id:{}) was updated at {}", naturalStyle.getName(), naturalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allNaturalStyles.jsp", "naturalStyles", naturalService.retrieveAll());
	}

	@GetMapping("AddNatural")
	public ModelAndView addNatural() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addNatural.jsp");
		modelAndView.addObject("naturalstyle", new NaturalStyle());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}

	@PostMapping("AddNaturalSubmit")
	public ModelAndView addBridalSubmit(@ModelAttribute("naturalstyle") NaturalStyle naturalStyle, ModelMap model) {
		naturalService.save(naturalStyle);
		LOGGER.warn("Natural Style {}(id:{}) was created at {}", naturalStyle.getName(), naturalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allNaturalStyles.jsp", "naturalStyles", naturalService.retrieveAll());
	}

	@RequestMapping(value = "DeleteNatural", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteNatural(@RequestParam("id") Long id) {
		Optional<NaturalStyle> naturalStyle = naturalService.findById(id);
		NaturalStyle naturalStyleName = naturalService.findByName(naturalStyle.get().getName());
		naturalService.delete(naturalStyleName);
		LOGGER.warn("Natural Style {}(id:{}) was deleted at {}", naturalStyle.get().getName(), naturalStyle.get().getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allNaturalStyles.jsp", "naturalStyles", naturalService.retrieveAll());
	}
}
