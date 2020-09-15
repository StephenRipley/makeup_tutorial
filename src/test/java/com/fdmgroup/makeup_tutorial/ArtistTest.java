package com.fdmgroup.makeup_tutorial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.StyleType;
import com.fdmgroup.makeup_tutorial.service.ArtistService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ArtistTest {

	@Autowired
	ArtistService artistService;

	@Test
	public void testThatAnArtistCanBeCreated() {
		Artist artist = new Artist("Stephen", "Ripley", StyleType.BRIDAL, "stephen_ripley@email.com", "password",
				"Instagram: @fakeaccount");
		int artistBeforeAdding = artistService.retrieveAll().size();
		artistService.save(artist);
		int artistAfterAdding = artistService.retrieveAll().size();
		assertNotEquals(artistBeforeAdding, artistAfterAdding);

	}

	@Test
	public void testThatAnArtistCanBeRetrievedByTheirEmailAndPassword() {
		Artist artist = artistService.findByEmailAndPassword("johnsmith@email.com", "2");
		assertNotNull(artist);
	}
	
	@Test
	public void testThatAnArtistCanBeRetrievedByTheirId() {
		Artist artist = artistService.findById(1);
		assertNotNull(artist);
	}

	@Test
	public void testThatAnArtistCanBeRetrievedByRetrievedEmail() {
		Artist artist = artistService.findByEmail("johnsmith@email.com");
		assertNotNull(artist);
	}

	@Test
	public void testThatAnArtistCannotBeRetrievedUsingTheWrongPassword() {
		Artist artist = artistService.findByEmailAndPassword("johnsmith@email.com", "5");
		assertNull(artist);
	}

	@Test
	public void testThatAnUnknownArtistCannotBeRetrievedByEmail() {
		Artist artist = artistService.findByEmail("fakeemail@email.com");
		assertNull(artist);
	}
	
	@Test
	public void testThatAnArtistCanBeUpdated() {
		Artist artist = artistService.findByEmail("johnsmith@email.com");
		artist.setFirstname("Craig");
		artistService.save(artist);
		assertEquals("Craig", artist.getFirstname());
	}

}
