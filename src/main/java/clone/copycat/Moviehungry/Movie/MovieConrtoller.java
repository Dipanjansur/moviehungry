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

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@RequestParam Long id, @RequestParam Long uuid) {
        if (id == null && uuid == null) {
            throw new NotValidArguments("please pass some valid argument", "nither id nor uuid is present in the Request param");
        }
        return ResponseEntity.ok(movieservice.findMovieByidOruuid(id, uuid));
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<MovieDTO>> getMovieByTitle(@RequestParam String title) {
        List<MovieDTO>movieByTittle= movieservice.findMovieByTittle(title);
    return ResponseEntity.ok(movieByTittle);
    }
}
