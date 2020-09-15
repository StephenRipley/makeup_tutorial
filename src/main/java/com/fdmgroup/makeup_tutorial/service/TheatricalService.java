package com.fdmgroup.makeup_tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.makeup_tutorial.model.TheatricalStyle;
import com.fdmgroup.makeup_tutorial.repository.TheatricalDao;

@Service
public class TheatricalService implements StyleServiceRepository<TheatricalStyle>{
	
	@Autowired
	private TheatricalDao theatricalDao;

	@Override
	public TheatricalStyle findByName(String name) {
		return theatricalDao.findByName(name);
	}

	@Override
	public void save(TheatricalStyle theatricalStyle) {
		theatricalDao.save(theatricalStyle);
	}

	@Override
	public void delete(TheatricalStyle theatricalStyle) {
		theatricalDao.delete(theatricalStyle);
		
	}

	@Override
	public List<TheatricalStyle> retrieveAll() {
		return theatricalDao.findAll();
	}

	@Override
	public Optional<TheatricalStyle> findById(Long theatricalId) {
		return theatricalDao.findById(theatricalId);
	}



}
