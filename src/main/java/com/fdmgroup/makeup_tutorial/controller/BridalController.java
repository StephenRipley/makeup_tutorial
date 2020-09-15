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

import com.fdmgroup.makeup_tutorial.model.BridalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.BridalService;

@Controller
public class BridalController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(BridalController.class);

	@Autowired
	private BridalService bridalService;

	@Autowired
	private ArtistService artistService;

	@GetMapping("AllBridalStyles")
	public ModelAndView allBridals() {
		return new ModelAndView("WEB-INF/allBridalStyles.jsp", "bridalStyles", bridalService.retrieveAll());
	}

	@GetMapping("DisplayBridal")
	public ModelAndView displayBridal(@RequestParam("id") Long id) {
		Optional<BridalStyle> bridalStyle = bridalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/displayBridal.jsp");
		modelAndView.addObject("bridalstyle", bridalStyle.get());
		return modelAndView;
	}

	@GetMapping("EditBridal")
	public ModelAndView editBridal(@RequestParam("id") Long id) {
		Optional<BridalStyle> bridalStyle = bridalService.findById(id);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/editBridal.jsp");
		modelAndView.addObject("bridalstyle", bridalStyle.get());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}

	@PostMapping("EditBridalSubmit")
	public ModelAndView editBridalSubmit(@ModelAttribute("bridalstyle") BridalStyle bridalStyle, ModelMap model) {
		bridalService.save(bridalStyle);
		LOGGER.warn("Bridal Style {}(id:{}) was updated at {}", bridalStyle.getName(), bridalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allBridalStyles.jsp", "bridalStyles", bridalService.retrieveAll());
	}

	@GetMapping("AddBridal")
	public ModelAndView addBridal() {
		ModelAndView modelAndView = new ModelAndView("WEB-INF/addBridal.jsp");
		modelAndView.addObject("bridalstyle", new BridalStyle());
		modelAndView.addObject("allArtists", artistService.retrieveAll());
		return modelAndView;
	}

	@PostMapping("AddBridalSubmit")
	public ModelAndView addBridalSubmit(@ModelAttribute("bridalstyle") BridalStyle bridalStyle, ModelMap model) {
		bridalService.save(bridalStyle);
		LOGGER.warn("Bridal Style {}(id:{}) was created at {}", bridalStyle.getName(), bridalStyle.getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allBridalStyles.jsp", "bridalStyles", bridalService.retrieveAll());

	}
	@RequestMapping(value = "DeleteBridal", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteBridal(@RequestParam("id") Long id) {
		Optional<BridalStyle> bridalStyle = bridalService.findById(id);
		BridalStyle bridalStyleName = bridalService.findByName(bridalStyle.get().getName());
		bridalService.delete(bridalStyleName);
		LOGGER.warn("Bridal Style {}(id:{}) was deleted at {}", bridalStyle.get().getName(), bridalStyle.get().getMakeupStyleId(),LocalDateTime.now());
		return new ModelAndView("WEB-INF/allBridalStyles.jsp", "bridalStyles", bridalService.retrieveAll());
	}

}
