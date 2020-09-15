package com.fdmgroup.makeup_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.makeup_tutorial.model.Subscriber;

public interface SubscriberDao extends JpaRepository<Subscriber, Long> {
	
	Subscriber findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	Subscriber findByEmail(@Param("email") String email);
	
	Subscriber findById(@Param("subscriberId") long subscriberId);
}
