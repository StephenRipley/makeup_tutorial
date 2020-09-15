package com.fdmgroup.makeup_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fdmgroup.makeup_tutorial.model.Artist;

public interface ArtistDao extends JpaRepository<Artist, Long>{

	Artist findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	Artist findByEmail(@Param("email") String email);
	
	Artist findById(@Param("artistId") long artistId);

}
