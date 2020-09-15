package com.fdmgroup.makeup_tutorial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.model.NaturalStyle;
import com.fdmgroup.makeup_tutorial.service.ArtistService;
import com.fdmgroup.makeup_tutorial.service.NaturalService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class NaturalTest {

	@Autowired
	NaturalService naturalService;

	@Autowired
	ArtistService artistService;

	@Test
	public void testThatANaturalLookCanBeRetrievedUsingItsName() {
		NaturalStyle naturalStyle = naturalService.findByName("QuickMorning");
		assertNotNull(naturalStyle);
	}
	@Test
	public void testThatANaturalLookCanBeRetrievedUsingItsId() {
		Optional<NaturalStyle> naturalStyle = naturalService.findById(5L);
		assertNotNull(naturalStyle);
	}
	@Test
	public void testThatAnUnknownLookCannotBeRetrievedByName() {
		NaturalStyle naturalStyle = naturalService.findByName("Fakename");
		assertNull(naturalStyle);
	}

	@Test
	public void testThatANaturalLookCanBeCreated() {
		Artist artist = artistService.findById(2);
		NaturalStyle naturalStyle = new NaturalStyle();
		naturalStyle.setName("Daytime");
		naturalStyle.setDescription("Everyday natural look");
		naturalStyle.setColourScheme("Brown/black");
		naturalStyle.setProducts("Concealer");
		naturalStyle.setCompletionTime(30);
		naturalStyle.setTutorial("Paint yoself");
		naturalStyle.setArtist(artist);
		naturalStyle.setRating(4);
		naturalService.save(naturalStyle);
		System.out.println(naturalStyle);
	}

	@Test
	public void testThatANaturalLookCanBeUpdated() {
		NaturalStyle naturalStyle = naturalService.findByName("FullMorning");
		naturalStyle.setRating(1);
		naturalService.save(naturalStyle);
		assertEquals(1, naturalStyle.getRating());
	}

	@Test
	public void testThatANaturalLookCanBeDeleted() {
		NaturalStyle naturalStyle = naturalService.findByName("QuickMorning");
		int nStyleBeforeDelete = naturalService.retrieveAll().size();
		naturalService.delete(naturalStyle);
		int nStyleAfterDelete = naturalService.retrieveAll().size();
		assertNotEquals(nStyleAfterDelete, nStyleBeforeDelete);
	}

}
