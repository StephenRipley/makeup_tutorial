package com.fdmgroup.makeup_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.makeup_tutorial.model.NaturalStyle;

public interface NaturalDao extends JpaRepository<NaturalStyle, Long>{
	
	NaturalStyle findByName(@Param("name") String name);

}
