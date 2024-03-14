package clone.copycat.Moviehungry.ShowSeats.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateSeatsDTO {
    @NotBlank
    private String  parentshow;
    @NumberFormat(pattern ="##")
    @Size(max = 2, message = "Seat number must not exceed 2 characters")
    private String seatNumber;
    @Min(value = 1, message = "Row number must be at least 1")
    private Integer rowNum;
    @Min(value = 'A', message = "Column number must be bigger than A")
    private String columnNum;
}
