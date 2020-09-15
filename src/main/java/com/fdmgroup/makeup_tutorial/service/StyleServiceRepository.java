package com.fdmgroup.makeup_tutorial.service;

import java.util.List;
import java.util.Optional;

public interface StyleServiceRepository<T> {
	
	T findByName(String name);
	
	List<T> retrieveAll();
	
	void save(T style);

	void delete(T style);

	Optional<T> findById(Long id);

}
