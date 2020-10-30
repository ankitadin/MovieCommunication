package com.my.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.my.model.Movie;
import com.my.model.Rating;
import com.my.repo.MovieRepo;

@RestController
public class MovieResource {
	
	@Autowired
	RestTemplate tt;
	
	
	
    @Autowired
	MovieRepo mr;
	
	@GetMapping("/test")
	public String testget()
	{
		return ("<h1>Hello anki</h1>");
	}
	
	
	
	@PostMapping("/save")
	public Movie saveMovie(@RequestBody Movie m)
	{
		Movie mm=mr.save(m);
		return mm;
		
	}
	
	@GetMapping("/urltest/{id}")
	public Movie getratingInfo(@PathVariable(value="id") long id)
	{
		Movie m=mr.findById(id).orElseThrow(()->new RuntimeException());
		
		Rating g=tt.getForObject("http://localhost:8086/getrating/"+id,Rating.class);
	        g.setRating(g.getRating());
	       
		System.out.println("%%%%%%%%");
		System.out.println(g.getMovieId()+"  "+g.getRating());
		System.out.println("%%%%%%%%%%");
		
		return new Movie(m.getMovieId(),m.getName(),g.getRating());
	}

}
