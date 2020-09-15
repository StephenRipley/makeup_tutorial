package com.fdmgroup.makeup_tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.makeup_tutorial.model.Artist;
import com.fdmgroup.makeup_tutorial.repository.ArtistDao;

@Service
public class ArtistService implements UserServiceRepository<Artist> {

	@Autowired
	private ArtistDao artistDao;
	
	
	@Override
	public Artist findByEmailAndPassword(String email, String password) {
		return artistDao.findByEmailAndPassword(email, password);
	}

	@Override
	public Artist findByEmail(String email) {
		return artistDao.findByEmail(email);
	}
	
	@Override
	public Artist findById(long artistId) {
		return artistDao.findById(artistId);
	}

	@Override
	public void save(Artist artist) {
		artistDao.save(artist);
	}

	@Override
	public List<Artist> retrieveAll() {
		return artistDao.findAll();
	}

}
