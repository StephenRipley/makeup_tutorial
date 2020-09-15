package com.fdmgroup.makeup_tutorial;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.makeup_tutorial.model.Subscriber;
import com.fdmgroup.makeup_tutorial.service.SubscriberService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class SubscriberTest {

	@Autowired
	SubscriberService subscriberService;

	@Test
	public void testSubscriberCanBeCreated() {
		Subscriber subscriber = new Subscriber("Rick", "Sanchez", "rs@email.com", "wubba");
		int subscriberBeforeAdding = subscriberService.retrieveAll().size();
		subscriberService.save(subscriber);
		int subscriberAfterAdding = subscriberService.retrieveAll().size();
		assertNotEquals(subscriberAfterAdding, subscriberBeforeAdding);
	}

	@Test
	public void testUserSubscriberBeRetrievedByTheirEmailAndPassword() {
		Subscriber subscriber = subscriberService.findByEmailAndPassword("stevie@email.com", "1");
		assertNotNull(subscriber);
	}
	
	@Test
	public void testThatASubscriberCanBeRetrievedByTheirId() {
		Subscriber subscriber = subscriberService.findById(1);
		assertNotNull(subscriber);
	}

	@Test
	public void testThatAUserSubscriberBeRetrievedByTheirEmail() {
		Subscriber subscriber = subscriberService.findByEmail("stevie@email.com");
		assertNotNull(subscriber);

	}

	@Test
	public void testThatASubscriberCannotBeRetrievedUsingTheWrongPassword() {
		Subscriber subscriber = subscriberService.findByEmailAndPassword("stevie@email.com", "2");
		assertNull(subscriber);
	}

	@Test
	public void testThatAnUnknownUserCannotBeRetrievedByEmail() {
		Subscriber user = subscriberService.findByEmail("fakeemail@email.com");
		assertNull(user);
	}
	
	@Test
	public void testThatAUserCanBeUpdated() {
		Subscriber user = subscriberService.findByEmail("stevie@email.com");
		user.setFirstname("dave");
		subscriberService.save(user);
		assertEquals("dave", user.getFirstname());
	}

}
