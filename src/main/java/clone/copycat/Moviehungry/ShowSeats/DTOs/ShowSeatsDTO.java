package clone.copycat.Moviehungry.ShowSeats.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatsDTO {
    private Long uuid;
    private ShowDAO parentshow;
    private String seatNumber;
    private long rowNumber;
    private long columnNumber;
    private boolean available;
}
