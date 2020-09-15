package com.fdmgroup.makeup_tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.makeup_tutorial.model.Subscriber;
import com.fdmgroup.makeup_tutorial.repository.SubscriberDao;


@Service
public class SubscriberService implements UserServiceRepository<Subscriber>{

	@Autowired
	private SubscriberDao subscriberDao;
	
	@Override
	public Subscriber findByEmail(String email) {
		return subscriberDao.findByEmail(email);
	}

	@Override
	public void save(Subscriber subscriber) {
		subscriberDao.save(subscriber);
		
	}

	@Override
	public List<Subscriber> retrieveAll() {
		return subscriberDao.findAll();
	}

	@Override
	public Subscriber findById(long subscriberId) {
		return subscriberDao.findById(subscriberId);
	}

	@Override
	public Subscriber findByEmailAndPassword(String email, String password) {
		return subscriberDao.findByEmailAndPassword(email, password);
	}
	
	

}
