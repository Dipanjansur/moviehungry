package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("movies/admin")
public class MovieAdminController {
    private MovieService movieService;

    @Autowired
    public MovieAdminController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewMovie(@RequestBody CreateMovieDTO movieRequest) {
      MovieDTO createdMovie=  movieService.addMovie(movieRequest);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("Status","movie added successfully");
        response.put("Added movie:",response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
