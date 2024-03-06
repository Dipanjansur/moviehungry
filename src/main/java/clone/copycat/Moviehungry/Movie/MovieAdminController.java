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
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }
}
