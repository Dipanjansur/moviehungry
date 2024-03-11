package clone.copycat.Moviehungry.Show.DTOs;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShowDTO {
    private String movieId;
    private Long theaterId;
    private LocalDateTime showTime;
    private Long totalCapacity;
}
