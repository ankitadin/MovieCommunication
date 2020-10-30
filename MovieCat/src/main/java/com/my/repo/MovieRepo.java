package com.my.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.model.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long>{

}
