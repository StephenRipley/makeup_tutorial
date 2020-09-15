package com.fdmgroup.makeup_tutorial.service;

import java.util.List;

public interface UserServiceRepository<T> {
	
	T findByEmail(String email);

	T findById(long id);

	T findByEmailAndPassword(String email, String password);
	
	void save(T user);

	List<T> retrieveAll();
	
}
