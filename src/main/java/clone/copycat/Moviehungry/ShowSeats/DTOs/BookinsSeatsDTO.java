package clone.copycat.Moviehungry.ShowSeats.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookinsSeatsDTO {
    @NotBlank
    private String  parentshow;
    @NotBlank
    private String seatNumber;
}
