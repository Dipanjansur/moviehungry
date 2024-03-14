package clone.copycat.Moviehungry.Show.DTOs;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShowDTO {
    @NotBlank
    private String movieId;
    private Long theaterId;
    @FutureOrPresent
    private LocalDateTime showTime;
    @Min(value = 1,message="the minimum value should be greater than 1")
    @Max(value =30000,message="the maximum value should be less than 30000")
    @NumberFormat(pattern = "##")
    private Long totalCapacity;
    public void setMovieId(String movieId) {
        this.movieId= movieId.trim().toLowerCase();
    }
}
