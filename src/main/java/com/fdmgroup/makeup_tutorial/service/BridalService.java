package com.fdmgroup.makeup_tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.makeup_tutorial.model.BridalStyle;
import com.fdmgroup.makeup_tutorial.repository.BridalDao;

@Service
public class BridalService implements StyleServiceRepository<BridalStyle>{
	
	@Autowired
	private BridalDao bridalDao;

	@Override
	public BridalStyle findByName(String name) {
		return bridalDao.findByName(name);
	}

	@Override
	public void save(BridalStyle bridalStyle) {
		bridalDao.save(bridalStyle);
		
	}

	@Override
	public void delete(BridalStyle bridalStyle) {
		bridalDao.delete(bridalStyle);
	}

	@Override
	public List<BridalStyle> retrieveAll() {
		return bridalDao.findAll();
	}

	@Override
	public Optional<BridalStyle> findById(Long bridalId) {
		return bridalDao.findById(bridalId);
	}

}
