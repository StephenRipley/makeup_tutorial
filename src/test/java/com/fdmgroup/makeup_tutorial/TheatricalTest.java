package com.fdmgroup.makeup_tutorial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.TheatricalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.TheatricalService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TheatricalTest {

	@Autowired
	TheatricalService theatricalService;
	
	@Autowired
	ArtistService artistService;
	
	@Test
	public void testThatATheatricalLookCanBeRetrievedUsingItsName() {
		TheatricalStyle theatricalStyle = theatricalService.findByName("Skeleton");
		assertNotNull(theatricalStyle);
	}
	
	@Test
	public void testThatATheaticalLookCanBeRetrievedUsingItsId() {
		Optional<TheatricalStyle> theatricalStyle = theatricalService.findById(2L);
		assertNotNull(theatricalStyle);
	}
	@Test
	public void testThatAnUnknownLookCannotBeRetrievedByName() {
		TheatricalStyle theatricalStyle = theatricalService.findByName("Devil");
		assertNull(theatricalStyle);
	}
	
	@Test
	public void testThatATheatricalLookCanBeCreated() {
		Artist artist = artistService.findById(1);
		TheatricalStyle theatricalStyle = new TheatricalStyle();
		theatricalStyle.setName("Ghost");
		theatricalStyle.setDescription("Spooky");
		theatricalStyle.setTheme("Halloween");
		theatricalStyle.setProducts("White face paint");
		theatricalStyle.setCompletionTime(30);
		theatricalStyle.setTutorial("Do some stuff");
		theatricalStyle.setArtist(artist);
		theatricalStyle.setRating(4);
		theatricalService.save(theatricalStyle);
	}
	
	@Test
	public void testThatATheatricalLookCanBeDeleted() {
		TheatricalStyle theatricalStyle = theatricalService.findByName("Skeleton");
		int tStyleBeforeDelete = theatricalService.retrieveAll().size();
		theatricalService.delete(theatricalStyle);
		int tStyleAfterDelete = theatricalService.retrieveAll().size();
		assertNotEquals(tStyleAfterDelete, tStyleBeforeDelete);
	}
	
	@Test
	public void testThatATheatricalLookCanBeUpdated() {
		TheatricalStyle theaticalStyle = theatricalService.findByName("Skeleton");
		theaticalStyle.setTutorial("brand new tutorial");
		theatricalService.save(theaticalStyle);
		assertEquals("brand new tutorial", theaticalStyle.getTutorial());
	}
	

}
