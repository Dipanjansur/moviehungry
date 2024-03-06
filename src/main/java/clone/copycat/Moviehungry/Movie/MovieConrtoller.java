package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Customexceptions.NotValidArguments;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The MovieConrtoller class is a controller class that handles HTTP requests related to movies.
 * It provides endpoints for searching movies by title, retrieving all movies, and searching movies by ID or UUID.
 * The class is responsible for interacting with the MovieService to perform the necessary operations.
 *
 * Endpoints:
 * - GET /movies/search/{title}: Retrieves a list of movies that match the given title.
 * - GET /movies/: Retrieves a list of all movies.
 * - GET /movies/search: Retrieves a movie by ID or UUID.
 *
 * Example usage:
 * MovieConrtoller movieConrtoller = new MovieConrtoller(movieService);
 * ResponseEntity<List<MovieDTO>> movieByTitle = movieConrtoller.getMovieByTitle("The Avengers");
 * ResponseEntity<List<MovieDTO>> allMovies = movieConrtoller.getAllMovies();
 * ResponseEntity<MovieDTO> movieById = movieConrtoller.getMovieById(1L, null);
 *
 * Note: This class requires the MovieService to be injected via constructor injection.
 */

@RestController
@RequestMapping("movies")
public class MovieConrtoller {
    private MovieService movieservice;

    @Autowired
    public MovieConrtoller(MovieService movieservice) {
        this.movieservice = movieservice;
    }
    /**
     * This method is used to fetch a list of movies by their title.
     *
     * @param title The title of the movie to be searched.
     * @return ResponseEntity containing a list of MovieDTO objects that match the provided title, and HTTP status code.
     * @throws NosuchEntity If no movie with the provided title is found.
     */
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
