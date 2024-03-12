package clone.copycat.Moviehungry.ShowSeats.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class BookinsSeatsDTO {
    private String  parentshow;
    private String seatNumber;
}
