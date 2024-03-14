package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
public class ShowsController {
    private ShowsService showsService;

    private final ShowsRepository showsRepository;

    @Autowired
    public ShowsController(ShowsService showsService, ShowsRepository showsRepository) {
        this.showsService = showsService;
        this.showsRepository = showsRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<ShowDTO>> allshows() {

        return ResponseEntity.ok(showsService.findAllShows());
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShowDTO>> search(
            @RequestParam(name = "cityName", required = false) String cityName,
            @RequestParam(name = "movieId", required = false) Long movieId,
            @RequestParam(name = "theaterName", required = false) String theaterName) {
        List<ShowDTO> listedSearches;
        if (cityName != null && (movieId != null && theaterName != null)) {
            listedSearches = showsService.findByMovieNameAndCityAndTheather(movieId, cityName, theaterName);
        } else if (theaterName == null) {
            listedSearches = showsService.findByMovieNameAndCity(movieId, cityName);
        } else if (movieId == null) {
            listedSearches = showsService.findByTheaterAndCity(theaterName, cityName);
        } else if (cityName == null) {
            listedSearches = showsService.findbyMoviesAndTheathers(movieId, theaterName);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(listedSearches);
    }

    @GetMapping("/cityname")
    public ResponseEntity<List<ShowDTO>> searchbyCityName(@RequestParam String cityname) {
        List<ShowDTO> retval = showsService.findByCityname(cityname);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("/add")
    public ResponseEntity<ShowDTO> addShow(@RequestBody @Validated CreateShowDTO showResource) {
        ShowDTO retval = showsService.addNewShow(showResource);
        return ResponseEntity.ok(retval);
    }
}
