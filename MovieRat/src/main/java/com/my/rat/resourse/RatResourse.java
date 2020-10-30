package com.my.rat.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.rat.model.Rating;
import com.my.rat.repo.MovieRatRepo;


@RestController
public class RatResourse {
	
	@Autowired
	MovieRatRepo mr;
		
		
	@GetMapping("/test")
	public String testget()
	{
		return ("<h1>hello</h1>");
	}
	
	@PostMapping("/save")
	public Rating saveRating(@RequestBody Rating r)
	{
		Rating rr=mr.save(r);
		
		return rr;
	}
	
	
	@GetMapping("/getrating/{id}")
	public Rating getRating(@PathVariable(value="id") long id)
	{
		Rating rr=mr.findById(id).orElseThrow(()->new RuntimeException("not found"));
		
		return rr;
	}

}
