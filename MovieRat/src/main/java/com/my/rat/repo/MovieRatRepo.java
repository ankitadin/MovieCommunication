package com.my.rat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.rat.model.Rating;

@Repository
public interface MovieRatRepo  extends JpaRepository<Rating, Long>{
 
	
}
