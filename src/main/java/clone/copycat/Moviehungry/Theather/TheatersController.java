package clone.copycat.Moviehungry.Theather;

import clone.copycat.Moviehungry.Theather.DTOs.AddMoviesToTheathersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.AddTheatersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.TheatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theathers")
public class TheatersController {
    private TheatersService theatersService;

    @Autowired
    public TheatersController(TheatersService theatersService) {
        this.theatersService = theatersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<TheatherDTO>> findAllTheathers() {
        return ResponseEntity.ok(theatersService.findAllTheathers());
    }
    @GetMapping("/theather")
    public ResponseEntity<List<TheatherDTO>> findTheatherByName(@RequestParam String TheatherName) {
        return ResponseEntity.ok(theatersService.findTheatherByName(TheatherName));
    }

    @GetMapping("/cityName")
    public ResponseEntity<List<TheatherDTO>> findTheathersBYCity(@RequestParam String cityName) {
        return ResponseEntity.ok(theatersService.findTheathersBYCity(cityName));
    }

    //    public ResponseEntity<List<TheatersDAO>> findTheathersByMovieId(Long movieId){
//
//    }
    @PostMapping("/")
    public ResponseEntity<TheatherDTO> createNewTheather(@RequestBody AddTheatersDTO addNewTheathers) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(theatersService.createNewTheather(addNewTheathers));
    }

    @PostMapping("/shows/")
    public ResponseEntity<TheatherDTO> addNewShows(@RequestBody AddMoviesToTheathersDTO addMoviesToTheathersDTO) {
        return ResponseEntity.ok(theatersService.addNewShows(addMoviesToTheathersDTO));
    }
}
