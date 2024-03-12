package clone.copycat.Moviehungry.ShowSeats;

import clone.copycat.Moviehungry.ShowSeats.DTOs.BookinsSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.CreateSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.ShowSeatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/showseats")
public class ShowSeatsController {
    @Autowired
    private ShowSeatsService showSeatsService;


    @PostMapping("")
    public ResponseEntity<ShowSeatsDTO> createSeats(@RequestBody CreateSeatsDTO createSeatsDTO) {
       ShowSeatsDTO retval= showSeatsService.createSeat(createSeatsDTO);
      return  ResponseEntity.ok(retval);
    }
}
