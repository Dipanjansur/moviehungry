package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Customexceptions.NotValidArguments;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieConrtoller {
    private MovieService movieservice;

    @Autowired
    public MovieConrtoller(MovieService movieservice) {
        this.movieservice = movieservice;
    }

    @GetMapping("search/{title}")
    public ResponseEntity<List<MovieDTO>> getMovieByTitle(@PathVariable String title) {
        List<MovieDTO> movieByTittle = movieservice.findMovieByTittle(title);
        return ResponseEntity.ok(movieByTittle);
    }
    @GetMapping("/")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> getAllMovies=movieservice.getAllMovies();
        return ResponseEntity.ok(getAllMovies);

    }
    @GetMapping("/search")
    public ResponseEntity<MovieDTO> getMovieById(@RequestParam(required = false) Long id, @RequestParam(required = false) Long uuid) {
        if (id == null && uuid == null) {
            throw new NotValidArguments("please pass some valid argument", "nither id nor uuid is present in the Request param");
        }
        return ResponseEntity.ok(movieservice.findMovieByidOruuid(id, uuid));
    }

}
