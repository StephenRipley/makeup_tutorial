package com.fdmgroup.makeup_tutorial;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.BridalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.BridalService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class BridalTest {

	@Autowired
	BridalService bridalService;

	@Autowired
	ArtistService artistService;

	@Test
	public void testThatABridalLookCanBeRetrievedUsingItsName() {
		BridalStyle bridalStyle = bridalService.findByName("Summer1");
		assertNotNull(bridalStyle);
	}
	
	@Test
	public void testThatABridalLookCanBeRetrievedUsingItsId() {
		Optional<BridalStyle> bridalStyle = bridalService.findById(4L);
		assertNotNull(bridalStyle);
	}

	@Test
	public void testThatAnUnknownLookCannotBeRetrievedByName() {
		BridalStyle bridalStyle = bridalService.findByName("Winter3");
		assertNull(bridalStyle);
	}

	@Test
	public void testThatABridalLookCanBeCreated() {
		Artist artist = artistService.findById(1);
		BridalStyle bridalStyle = new BridalStyle();
		bridalStyle.setName("Winter1");
		bridalStyle.setDescription("Winter bridal look");
		bridalStyle.setColourScheme("Silver/Blue");
		bridalStyle.setProducts("F,C,P,L");
		bridalStyle.setCompletionTime(60);
		bridalStyle.setTutorial("Paint the face");
		bridalStyle.setArtist(artist);
		bridalStyle.setRating(5);
		bridalService.save(bridalStyle);
	}

	@Test
	public void testThatABridalLookCanBeUpdated() {
		BridalStyle bridalStyle = bridalService.findByName("Summer1");
		bridalStyle.setColourScheme("Brown");
		bridalService.save(bridalStyle);
		assertEquals("Brown", bridalStyle.getColourScheme());
	}

	@Test
	public void testThatABridalLookCanBeDeleted() {
		BridalStyle bridalStyle = bridalService.findByName("Summer1");
		int bStyleBeforeDelete = bridalService.retrieveAll().size();
		bridalService.delete(bridalStyle);
		int bStyleAfterDelete = bridalService.retrieveAll().size();
		assertNotEquals(bStyleAfterDelete, bStyleBeforeDelete);
	}
}
