package clone.copycat.Moviehungry.Tickets.DTOs;

import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import clone.copycat.Moviehungry.Users.UsersDAO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketBookingDTO {
    private Long id;
    private List<String> seatIds;
    private String userId;
}
