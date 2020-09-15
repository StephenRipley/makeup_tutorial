package com.fdmgroup.makeup_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.makeup_tutorial.model.BridalStyle;

public interface BridalDao extends JpaRepository<BridalStyle, Long>{
	
	BridalStyle findByName(@Param("name") String name);

}
