package clone.copycat.Moviehungry.ShowSeats.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSeatsDTO {
    private String  parentshow;
    private String seatNumber;
    private Integer rowNum;
    private String columnNum;
}
