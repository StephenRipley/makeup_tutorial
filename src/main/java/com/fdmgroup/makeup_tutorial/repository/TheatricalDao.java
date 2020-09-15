package com.fdmgroup.makeup_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.makeup_tutorial.model.TheatricalStyle;

public interface TheatricalDao extends JpaRepository<TheatricalStyle, Long>{
	
	TheatricalStyle findByName(@Param("name") String name);

}
