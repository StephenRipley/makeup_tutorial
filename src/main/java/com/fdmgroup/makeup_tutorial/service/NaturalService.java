package com.fdmgroup.makeup_tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.makeup_tutorial.model.NaturalStyle;
import com.fdmgroup.makeup_tutorial.repository.NaturalDao;

@Service
public class NaturalService implements StyleServiceRepository<NaturalStyle> {
	
	@Autowired
	private NaturalDao naturalDao;

	@Override
	public NaturalStyle findByName(String name) {
		return naturalDao.findByName(name);
	}

	@Override
	public void save(NaturalStyle naturalStyle) {
		naturalDao.save(naturalStyle);
		
	}

	@Override
	public List<NaturalStyle> retrieveAll() {
		return naturalDao.findAll();
	}

	@Override
	public void delete(NaturalStyle naturalStyle) {
		naturalDao.delete(naturalStyle);
	}

	@Override
	public Optional<NaturalStyle> findById(Long naturalId) {
		return naturalDao.findById(naturalId);
	}

}
