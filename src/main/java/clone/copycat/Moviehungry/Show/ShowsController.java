package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shows")
public class ShowsController {
    private ShowsService showsService;

    @GetMapping("/search")
    public ResponseEntity<List<ShowDTO>> search(
            @RequestParam(name = "city", required = true) String cityName,
            @RequestParam(name = "movieName", required = false) Long movieName,
            @RequestParam(name = "theaterName", required = false) String theaterName) {
        Optional<List<ShowDTO>> listedSearches;
        if (cityName != null && (movieName != null && theaterName != null)) {
            listedSearches = showsService.findByMovieNameAndCityAndTheather(movieName, cityName, theaterName);
        } else if (theaterName == null) {
            listedSearches = showsService.findByMovieNameAndCity(movieName, cityName);
        } else if (movieName == null) {
            listedSearches = showsService.findByTheaterAndCity(theaterName, cityName);
        } else if (cityName == null) {
            listedSearches = showsService.findByTheaterAndCity(theaterName, cityName);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(listedSearches.get());
    }

    @PostMapping("/add")
    public ResponseEntity<ShowDTO> addShow(@RequestBody CreateShowDTO showResource) {
        return ResponseEntity.ok(showsService.addNewShow(showResource).get());
    }
}
