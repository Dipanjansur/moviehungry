package clone.copycat.Moviehungry.Tickets;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketBookingDTO;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    private TicketsService ticketsService;

    @Autowired
    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping("/search")
    public ResponseEntity<Object> booksSearchByUsersorUUId(@RequestParam(name = "userId", required = false) Long userid, @RequestParam(name = "username", required = false) String username) {
        if (userid == null && username == null) {
            throw new IllegalArguments("pass one of the parameters userId or Username to seach for a ticket");
        } else if (userid == null) {
          return ResponseEntity.ok(ticketsService.booksSearchByUser(username));
        }else{
          return ResponseEntity.ok(ticketsService.booksSearchByUserId(userid));
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Object> bookTicket(@RequestBody TicketBookingDTO ticketBookingDTO) {
      return ResponseEntity.ok(ticketsService.bookTicket(ticketBookingDTO));
    }

//    @PostMapping("/cancel")
//    public ResponseEntity<Object> cancelTicket(@RequestParam Long uuid) {
//
//    }
}
